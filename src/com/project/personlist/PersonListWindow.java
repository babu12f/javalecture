package com.project.personlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonListWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("person_list.fxml"));

        Scene scene = new Scene(parent);

        primaryStage.setTitle("Person List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
