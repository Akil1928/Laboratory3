package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class HelloController {
    @FXML
    private void load (String form){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(form));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private BorderPane bp;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Text txtMessage;

    @FXML
    void Exit(ActionEvent event) {

    }

    @FXML
    void Home(ActionEvent event) {
        txtMessage.setText("Laboratory No. 3");
        contentPane.getChildren().clear();
        contentPane.getChildren().add(txtMessage);
    }

    @FXML
    void dinamicOnAction(ActionEvent event) {

    }

    @FXML
    void probabilisticOnAction(ActionEvent event) {

    }

    @FXML
    void vectorOnAction(ActionEvent event) {

        load("vector.fxml");
    }

}