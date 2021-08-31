package com.prac;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TempPrac extends Application {

    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();
        Button playButton = new Button("Play");
        Button stopButton = new Button("stop");

        VBox vBox = new VBox();

        //vBox.setSpacing(10);

        vBox.setMargin(textField, new Insets(20, 20, 20, 20));
        //vBox.setMargin(playButton, new Insets(20, 20, 20, 20));
        //vBox.setMargin(stopButton, new Insets(20, 20, 20, 20));

        vBox.getChildren().addAll(textField, playButton, stopButton);

        Scene scene = new Scene(vBox);

        stage.setTitle("Vbox Example");

        stage.setScene(scene);

        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
