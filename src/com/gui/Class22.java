package com.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Class22 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("First JavaFX GUI");

        Label label = new Label("Name:");
        label.setLayoutX(10);
        label.setLayoutY(10);
        label.setMaxWidth(100);
        label.setStyle("-fx-text-fill: white; -fx-background-color: green;");

        TextField tfFN = new TextField();
        tfFN.setLayoutX(100);
        tfFN.setLayoutY(10);
        tfFN.setStyle("-fx-border-color: red; -fx-border-radius: 50; -fx-border-width: 3; -fx-background-radius: 50");

        Label lblLn = new Label("Age:");
        lblLn.setLayoutX(10);
        lblLn.setLayoutY(50);
        lblLn.setMaxWidth(100);
        lblLn.setStyle("-fx-text-fill: white");

        TextField tfLn = new TextField();
        tfLn.setLayoutX(100);
        tfLn.setLayoutY(50);


        Button button = new Button("Save");
        button.setLayoutX(100);
        button.setLayoutY(90);

        button.setStyle("-fx-background-color: #3592C4; -fx-text-fill: white;");

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #2B2B2B");
        pane.getChildren().addAll(label, tfFN, lblLn, tfLn, button);

        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
