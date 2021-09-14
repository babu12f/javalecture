package com.project.personlist;

import com.project.db.PersonRepository;
import com.project.models.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

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

        tableView.getItems().addAll(allPerson);
    }

    @FXML
    private void getSelectedRow() {
        Person person = tableView.getSelectionModel().getSelectedItem();

        System.out.println(person);
    }

}
