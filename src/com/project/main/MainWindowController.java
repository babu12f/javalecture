package com.project.main;

import com.project.db.PersonRepository;
import com.project.editperson.EditPersonController;
import com.project.models.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class MainWindowController {

    private PersonRepository personRepository = new PersonRepository();
    private Person person = null;

    @FXML
    private BorderPane containerTabRoot;

    @FXML
    Button btnEdit;
    @FXML
    Button btnDelete;
    @FXML
    Label lblName;
    @FXML
    Label lblAge;
    @FXML
    Label lblAddress;
    @FXML
    Label lblEmail;
    @FXML
    Label lblId;
    @FXML
    TextField txtSearchId;

    @FXML
    public void showPersonList() throws IOException {
        //Stage stage = new Stage();

        Parent parent = FXMLLoader.load(getClass().getResource("../personlist/person_list.fxml"));

        containerTabRoot.setCenter(parent);

        //Scene scene = new Scene(parent);
        /*stage.setTitle("Person List");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();*/
    }

    @FXML
    public void showAddPerson() throws IOException {
        //Stage stage = new Stage();

        Parent parent = FXMLLoader.load(getClass().getResource("../addperson/add_person.fxml"));

        containerTabRoot.setCenter(parent);
       /* Scene scene = new Scene(parent);

        stage.setTitle("Add Person");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();*/
    }

    @FXML
    private void clickSearch() {

        Integer id = Integer.parseInt(txtSearchId.getText());
        person = personRepository.findById(id);

        if (person != null) {
            fillPersonData(person);

            btnEdit.setDisable(false);
            btnDelete.setDisable(false);
        }
        else {
            btnEdit.setDisable(true);
            btnDelete.setDisable(true);
            cleanPersonData();
        }
    }

    @FXML
    private void editBtnClick() throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../editperson/edit_person.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        EditPersonController controller = fxmlLoader.getController();

        controller.fillPersonEditForm(this.person);

        stage.setTitle("Edit Person");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void deletePersonBtnClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Delete Person Information Confirm Dialogue");
        alert.setHeaderText("Need Your Confirmation");
        alert.setContentText("Are you sure to Delete This Person Information?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){
            Integer id = person.getId(); //Integer.parseInt(txtSearchId.getText());
            personRepository.deleteById(id);
            Alert deleteInfoAlert = new Alert(Alert.AlertType.INFORMATION);

            deleteInfoAlert.setTitle("Delete Success");
            deleteInfoAlert.setContentText("Data Deleted successfully !!!");
            deleteInfoAlert.show();
            cleanPersonData();
        }
        else {
            System.out.println("click cancel");
        }
    }

    private void fillPersonData(Person person) {
        lblName.setText(person.getName());
        lblAge.setText(String.valueOf(person.getAge()));
        lblAddress.setText(person.getAddress());
        lblEmail.setText(person.getEmail());
        lblId.setText(String.valueOf(person.getId()));
    }

    private void cleanPersonData() {
        lblName.setText("");
        lblAge.setText("");
        lblAddress.setText("");
        lblEmail.setText("");
        lblId.setText("");
    }
}
