package com.project.editperson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditPersonWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("edit_person.fxml"));

        Scene scene = new Scene(parent);

        primaryStage.setTitle("Edit person");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
