package util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

public class FXUtility {
    public static Alert myalert (String title, String headerText){
        Alert myalert = new Alert(Alert.AlertType.NONE);
        myalert.setAlertType(Alert.AlertType.ERROR);
        myalert.setTitle(title);
        myalert.setHeaderText(headerText);
        myalert.show();
        return myalert;
    }
    public static TextInputDialog dialog(String title, String headerText){
        TextInputDialog dialog = new TextInputDialog(title);
dialog.setHeaderText(headerText);


        return dialog;
    }
}
