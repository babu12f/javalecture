package com.gui.dd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DemoFxml {

    @FXML
    public TextField tfFirstName;

    @FXML
    public TextField tfLastName;

    @FXML
    public TextField tfAge;

    @FXML
    public TextField tfAddress;

    @FXML
    public TextField tfEmail;

    @FXML
    public void btnClickSavePerson() throws Exception {
        System.out.println(tfFirstName.getText());
        System.out.println(tfAge.getText());
        System.out.println(tfAddress.getText());
        System.out.println(tfEmail.getText());

        //Parent root = FXMLLoader.load(getClass().getResource("MyModalFxml.fxml"));
        Scene scene = new Scene(new Button("OK"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
