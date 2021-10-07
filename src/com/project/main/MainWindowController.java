package com.project.main;

import com.project.db.PersonRepository;
import com.project.editperson.EditPersonController;
import com.project.models.Person;
import com.project.personlist.PersonListController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    private static final String TAB_PERSON_ADD = "1";
    private static final String TAB_PERSON_LIST = "2";
    private static final String TAB_PERSON_EDIT = "3";

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
    private TabPane mainTab;

    @FXML
    public void showPersonList() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../personlist/person_list.fxml"));

        Node node = loader.load();

        PersonListController controller = loader.getController();

        controller.setPersonSelectCallback((p)-> {
            try {
                showEditPersonTab(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Tab tab = null;
        if (!isTabAlreadyPresent(TAB_PERSON_LIST)) {
            tab = new Tab("List of Person", node);
            tab.setId(TAB_PERSON_LIST);
            mainTab.getTabs().add(tab);
        }
        else {
            tab = getTabById(TAB_PERSON_LIST);
        }
        mainTab.getSelectionModel().select(tab);
    }

    @FXML
    public void showAddPerson() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("../addperson/add_person.fxml"));
        Tab tab = null;

        if (!isTabAlreadyPresent(TAB_PERSON_ADD)) {
            tab = new Tab("Add Person", node);
            tab.setId(TAB_PERSON_ADD);
            mainTab.getTabs().add(tab);
        }
        else {
            tab = getTabById(TAB_PERSON_ADD);
        }

        mainTab.getSelectionModel().select(tab);
    }

    private void showEditPersonTab(Person person) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../editperson/edit_person.fxml"));

        Node node = fxmlLoader.load();

        EditPersonController controller = fxmlLoader.getController();

        controller.fillPersonEditForm(person);

        Tab tab = null;

        if (!isTabAlreadyPresent(TAB_PERSON_EDIT)) {
            tab = new Tab("Add Person", node);
            tab.setId(TAB_PERSON_EDIT);
            mainTab.getTabs().add(tab);
        }
        else {
            tab = getTabById(TAB_PERSON_EDIT);
            tab.setContent(node);
        }

        mainTab.getSelectionModel().select(tab);

        controller.setPersonEditCompleteCallback(() -> closeEditPersonTab());
    }

    private void closeEditPersonTab() {
        Tab editTab = getTabById(TAB_PERSON_EDIT);
        mainTab.getTabs().remove(editTab);
    }

    private boolean isTabAlreadyPresent(String tabId) {
       if (getTabById(tabId) != null) {
           return true;
       }
       return false;
    }

    private Tab getTabById(String tabId) {
        ObservableList<Tab> tabs = mainTab.getTabs();

        for (Tab t : tabs) {
            if(t.getId().equals(tabId)){
                return t;
            }
        }

        return null;
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

        Node node = fxmlLoader.load();

        EditPersonController controller = fxmlLoader.getController();

        controller.fillPersonEditForm(this.person);

        Tab tab = null;
        if (!isTabAlreadyPresent(TAB_PERSON_EDIT)) {
            tab = new Tab("Edit Person", node);
            tab.setId(TAB_PERSON_EDIT);
            mainTab.getTabs().add(tab);
        }
        else {
            tab = getTabById(TAB_PERSON_EDIT);
        }

        mainTab.getSelectionModel().select(tab);
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
