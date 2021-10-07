package com.project.editperson;

import com.project.db.PersonRepository;
import com.project.functionalinterfaces.MyApplicationCallback;
import com.project.models.Person;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.function.Consumer;

public class EditPersonController {

    PersonRepository personRepository = new PersonRepository();

    Person person = null;

    /*private final ReadOnlyObjectWrapper<Person> curPerson = new ReadOnlyObjectWrapper<>();

    public ReadOnlyObjectProperty<Person> getCurPerson() {
        return curPerson;
    }*/

    private MyApplicationCallback personEditCompleteCallback;

    public void setPersonEditCompleteCallback(MyApplicationCallback callback) {
        this.personEditCompleteCallback = callback ;
    }

    @FXML
    AnchorPane anchorPane;

    @FXML
    public TextField tfFirstName;
    @FXML
    public TextField tfAge;
    @FXML
    public TextField tfAddress;
    @FXML
    public TextField tfEmail;
    @FXML
    public TextField tfId;

    @FXML
    public void btnClickSavePerson(Event event) throws Exception {
        String name = tfFirstName.getText();
        Integer age = Integer.parseInt(tfAge.getText());
        String address = tfAddress.getText();
        String email = tfEmail.getText();

        person.setName(name);
        person.setAge(age);
        person.setAddress(address);
        person.setEmail(email);

        personRepository.update(person);

        /*curPerson.set(null);
        curPerson.set(person);*/

        //personSelectCallback.accept(person);

        ///clearForm();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);
        alert.setContentText("Edit person Successful :)");

        alert.showAndWait();

        personEditCompleteCallback.taskComplete();

        //((Node)(event.getSource())).getScene().getWindow().hide();
    }

    public void fillPersonEditForm(Person person) {
        this.person = person;
        tfFirstName.setText(person.getName());
        tfAge.setText(String.valueOf(person.getAge()));
        tfAddress.setText(person.getAddress());
        tfEmail.setText(person.getEmail());
        tfId.setText(String.valueOf(person.getId()));
    }

    @FXML
    public void resetButtonOnAction() {
        clearForm();
    }

    private void clearForm() {
        tfFirstName.setText("");
        tfAge.setText("");
        tfAddress.setText("");
        tfEmail.setText("");
    }
}
