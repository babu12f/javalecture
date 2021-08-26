package com.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Class22VBox extends Application {
    int i = 1;
    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField();
        Button playButton = new Button("Add");
        Button stopButton = new Button("stop");

        textField.setMaxWidth(150);

        VBox vBox = new VBox();
        //vBox.setSpacing(10);

        vBox.setMargin(textField, new Insets(20, 30, 50, 100));

        /*vBox.setMargin(textField, new Insets(20, 20, 20, 20));
        vBox.setMargin(playButton, new Insets(20, 20, 20, 20));
        vBox.setMargin(stopButton, new Insets(20, 20, 20, 20));*/

        vBox.getChildren().addAll(textField, playButton, stopButton);
        playButton.setOnAction(event -> {
            vBox.getChildren().add(new Button("new button "+ i));
            i++;
        });

        Scene scene = new Scene(vBox, 300, 300);

        //Setting title to the Stage
        stage.setTitle("Vbox Example");
        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
