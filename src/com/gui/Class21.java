package com.gui;

import com.jdbcclass.Person;
import com.jdbcclass.PersonRepository;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Class21 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("First JavaFX GUI");

        Label label = new Label("Name:");
        label.setLayoutX(10);
        label.setLayoutY(10);
        label.setMaxWidth(100);

        TextField tfFN = new TextField();
        tfFN.setLayoutX(100);
        tfFN.setLayoutY(10);

        Label lblLn = new Label("Age:");
        lblLn.setLayoutX(10);
        lblLn.setLayoutY(50);
        lblLn.setMaxWidth(100);

        TextField tfLn = new TextField();
        tfLn.setLayoutX(100);
        tfLn.setLayoutY(50);

        Button button = new Button("Save");
        button.setLayoutX(100);
        button.setLayoutY(90);

        button.setOnAction(event -> {
            String name = tfFN.getText();
            int age = Integer.valueOf(tfLn.getText());

            Label message = new Label("Name : " + name + " "+ age);
            message.setLayoutX(10);
            message.setLayoutY(50);
            message.setMaxWidth(100);
            Pane pane = new Pane();
            pane.getChildren().addAll(message);

            Stage secondaryStage = new Stage();
            Scene scene1 = new Scene(pane, 200, 200);
            secondaryStage.setScene(scene1);
            secondaryStage.initModality(Modality.APPLICATION_MODAL);
            secondaryStage.show();


            System.out.println("Name : "+ name + " Age: " +age);
        });

        Pane pane = new Pane();

        pane.getChildren().addAll(label, tfFN, lblLn, tfLn, button);
        //pane.getChildren().add(button);

        Scene scene = new Scene(pane, 400, 300);

        //scene.setCursor(Cursor.CLOSED_HAND);
        //scene.setCursor(Cursor.OPEN_HAND);
        //scene.setCursor(Cursor.MOVE);

        primaryStage.setScene(scene);
        primaryStage.show();

        //Stage secondaryStage = new Stage();
        //secondaryStage.initModality(Modality.APPLICATION_MODAL);
        ///secondaryStage.initModality(Modality.WINDOW_MODAL);
        //secondaryStage.initModality(Modality.NONE);
        //secondaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
