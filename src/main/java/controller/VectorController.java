package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import domain.Vector;//NUestra clase vector
public class VectorController {
    private TextField nTExtField;
    Alert alert;

    Vector vector;

    public void initialize() {
        this.alert = util.FXUtility.myalert("Vector Algorit", "");
        alert.setAlertType(Alert.AlertType.ERROR);
    }
    @FXML
    private TextArea textArea;

    @FXML
    private TextField textfFiel;

    @FXML
    private TextField textfFiel1;

    @FXML
    void createOnAction(ActionEvent event) {
        int n = Integer.valueOf(this.nTExtField.getText());
        if (isValid(n)){
            this.vector = new Vector(n);
            this.textArea.setText("El vector has been created for"+n+" elements");
    }else{

}
}
private boolean isValid(int n) {

    return n>0;
    }

    @FXML
    void textfielOnAction(ActionEvent event) {

    }

}