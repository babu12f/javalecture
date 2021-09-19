package com.project.addperson;

import com.project.db.PersonRepository;
import com.project.models.Person;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class AddPersonController implements Initializable {

    PersonRepository personRepository = new PersonRepository();

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
    public void btnClickSavePerson(Event event) throws Exception {
        String name = tfFirstName.getText();
        Integer age = Integer.parseInt(tfAge.getText());
        String address = tfAddress.getText();
        String email = tfEmail.getText();

        Person person = new Person(name, age, address, email);

        personRepository.save(person);

        clearForm();

        ///((Node)(event.getSource())).getScene().getWindow().hide();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initEvent();
    }

    private void initEvent() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            System.out.println(text);

            if (text.matches("[0-9]*")) {
                return change;
            }

            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        tfAge.setTextFormatter(textFormatter);
    }
}
