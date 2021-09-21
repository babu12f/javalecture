package com.project.personlist;

import com.project.db.PersonRepository;
import com.project.editperson.EditPersonController;
import com.project.models.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class PersonListController {

    PersonRepository personRepository = new PersonRepository();

    List<Person> tableDataList = new ArrayList<>();

    @FXML
    TableView<Person> tableView;
    @FXML
    TableColumn<Person, Integer> columnId;
    @FXML
    TableColumn<Person, String> columnName;
    @FXML
    TableColumn<Person, Integer> columnAge;
    @FXML
    TableColumn<Person, String> columnEmail;
    @FXML
    TableColumn<Person, String> columnAddress;

    @FXML
    ContextMenu tableContextMenu;

    @FXML
    private void initialize() {
        initTableColumns();
        loadData();
    }

    public void initTableColumns() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private void loadData() {
        List<Person> allPerson = personRepository.findAllPerson();

        tableView.getItems().clear();
        tableView.getItems().addAll(allPerson);
    }

    @FXML
    private void getSelectedRow() {
        Person person = tableView.getSelectionModel().getSelectedItem();

        System.out.println(person);
    }

    @FXML
    private void clickOnEdtCM() throws IOException {
        Person person = tableView.getSelectionModel().getSelectedItem();

        if (person != null) {
            Stage stage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../editperson/edit_person.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            EditPersonController controller = fxmlLoader.getController();

            controller.fillPersonEditForm(person);

            /*controller.getCurPerson().addListener((obs, old, ne) -> {
                if (ne != null) {
                    loadData();
                }
            });*/

            Consumer<Person> personSelectCallback = (p) -> {
                System.out.println(p);
            };

            controller.setPersonSelectCallback(personSelectCallback);

            stage.setScene(scene);
            stage.setTitle("Person Edit form");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }

    }

    @FXML
    private void clickOnDeleteCM() {
        Person person = tableView.getSelectionModel().getSelectedItem();

        if (person == null) {
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Delete Person Information Confirm Dialogue");
        alert.setHeaderText("Need Your Confirmation");
        alert.setContentText("Are you sure to Delete This Person Information?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Integer id = person.getId();
            personRepository.deleteById(id);
            Alert deleteInfoAlert = new Alert(Alert.AlertType.INFORMATION);

            deleteInfoAlert.setTitle("Delete Success");
            deleteInfoAlert.setContentText("Data Deleted successfully !!!");
            deleteInfoAlert.showAndWait();
            loadData();
        }
        else {
            System.out.println("click cancel");
        }
    }

}
