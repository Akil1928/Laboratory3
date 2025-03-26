module ucr.laboratory3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.laboratory3 to javafx.fxml;
    exports ucr.laboratory3;
}