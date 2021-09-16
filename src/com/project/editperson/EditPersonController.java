package com.project.editperson;

import com.project.db.PersonRepository;
import com.project.models.Person;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EditPersonController {

    PersonRepository personRepository = new PersonRepository();

    Person person = null;

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

        clearForm();

        ((Node)(event.getSource())).getScene().getWindow().hide();
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
