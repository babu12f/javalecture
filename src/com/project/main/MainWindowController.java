package com.project.main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {


    @FXML
    public void showPersonList() throws IOException {
        Stage stage = new Stage();

        Parent parent = FXMLLoader.load(getClass().getResource("../personlist/person_list.fxml"));

        Scene scene = new Scene(parent);

        stage.setTitle("Person List");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void showAddPerson() throws IOException {
        Stage stage = new Stage();

        Parent parent = FXMLLoader.load(getClass().getResource("../addperson/add_person.fxml"));

        Scene scene = new Scene(parent);

        stage.setTitle("Add Person");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
