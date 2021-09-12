package com.project.addperson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPersonWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("add_person.fxml"));

        Scene scene = new Scene(parent);

        primaryStage.setTitle("Add person");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
