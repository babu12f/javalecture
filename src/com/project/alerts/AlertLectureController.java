package com.project.alerts;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class AlertLectureController {

    @FXML
    private void showSimpleAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Simple Alert");
        alert.setContentText("Data inserted successfully\nanother line");

        alert.show();
    }

    @FXML
    private void showExceptionDialog() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Look, an Exception Dialog");
        alert.setContentText("Could not find file blabla.txt!");

        Exception ex = new FileNotFoundException("Could not find file file.txt");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);

        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    @FXML
    private void showConfirmationDialogue() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation");
        alert.setHeaderText("Need Your Confirmation");
        alert.setContentText("Are you sure to Delete This Object?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){
            System.out.println("click ok");
        }
        else {
            System.out.println("click cancel");
        }
    }

    @FXML
    private void showConfirmationDialogueCustomButton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation");
        alert.setHeaderText("Need Your Confirmation");
        alert.setContentText("Are you sure to Delete This Object?");

        ButtonType buttonTypeOne = new ButtonType("Option One");
        ButtonType buttonTypeTwo = new ButtonType("Option Two");
        ButtonType buttonTypeThree = new ButtonType("Option Three");
        //ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType buttonTypeOk = new ButtonType("MyOK", ButtonBar.ButtonData.OK_DONE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeOk);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne) {
            System.out.println("select option one");
        }
        else if (result.get() == buttonTypeTwo) {
            System.out.println("select option two");
        }
        else if (result.get() == buttonTypeOk) {
            System.out.println("click ok");
        }
    }

    @FXML
    private void showDialogueWithInput() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("header");
        dialog.setContentText("Please enter your name: ");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            System.out.println("Your name is: " + result.get());
        }
        else{
            System.out.println("not value entered");
        }

    }



}
