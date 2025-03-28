package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import domain.Vector;//NUestra clase vector
import util.Utility;

public class VectorController {
    @FXML
    private TextField textField;
    @FXML
    private Alert alert;
    private Vector vector;
    @FXML
    private TextArea textArea;

    public void initialize() {
        this.alert = util.FXUtility.myalert("Vector Algorithm", "");
        alert.setAlertType(Alert.AlertType.INFORMATION);
    }
    private void showMessage(String message) {
        textArea.setText(message);
        alert.setContentText(message);
        alert.show();
    }

    private void showError(String message) {
        textArea.setText(message);
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
        alert.setAlertType(Alert.AlertType.INFORMATION); // Restaurar al tipo original
    }

    @FXML
    void addByIndexOnAction(ActionEvent event) {
        if (vector == null) {
            showError("Primero cree un vector");
            return;
        }

        try {
            // Agregar valor en posición intermedia
            int index = vector.size() / 2;
            int value = Utility.random(100);
            vector.add(index, value);
            showMessage("Valor " + value + " agregado en posición " + index);
        } catch (Exception e) {
            showError("No se pudo agregar el elemento");
        }
    }

    @FXML
    void addByValueOnAction(ActionEvent event) {
        if (vector == null) {
            showError("Primero cree un vector");
            return;
        }

        // Agregar un valor aleatorio
        int value = Utility.random(100);
        vector.add(value);
        showMessage("Valor agregado: " + value);
    }

    @FXML
    void cleanOnAction(ActionEvent event) {
        if (vector == null) {
            showError("Primero cree un vector");
            return;
        }

        vector.clear();
        showMessage("Vector limpiado");
    }

    @FXML
    void containsOnAction(ActionEvent event) {
        if (vector == null) {
            showError("Primero cree un vector");
            return;
        }

        // Buscar un valor aleatorio existente
        if (vector.size() > 0) {
            int index = Utility.random(vector.size());
            int valueToFind = (int) vector.get(index);
            boolean contains = vector.contains(valueToFind);
            showMessage("Contiene " + valueToFind + ": " + contains);
        } else {
            showError("Vector vacío");
        }
    }

    @FXML
    void createOnAction(ActionEvent event) {
        try {
            int n = Integer.parseInt(textField.getText());
            if (n > 0) {
                vector = new Vector(n);
                showMessage("Vector creado con tamaño: " + n);
            } else {
                showError("Tamaño inválido. Debe ser mayor a 0.");
            }
        } catch (NumberFormatException e) {
            showError("Ingrese un número válido.");
        }
    }

    @FXML
    void fillShowOnAction(ActionEvent event) {
        if (vector == null) {
            showError("Primero cree un vector");
            return;
        }

        // Llenar vector con valores aleatorios
        for (int i = 0; i < vector.getData().length; i++) {
            vector.add(Utility.random(100)); // Valores aleatorios entre 0 y 99
        }

        // Mostrar contenido
        showMessage("Vector lleno: " + vector.toString());
    }

    @FXML
    void remoteByValueOnAction(ActionEvent event) {
        if (vector == null) {
            showError("Primero cree un vector");
            return;
        }

        if (vector.size() > 0) {
            // Eliminar un valor existente
            int index = Utility.random(vector.size());
            int valueToRemove = (int) vector.get(index);
            Object removed = vector.remove(valueToRemove);
            showMessage("Removido " + valueToRemove + ": " + removed);
        } else {
            showError("Vector vacío");
        }
    }

    @FXML
    void removeByIndex(ActionEvent event) {
        if (vector == null) {
            showError("Primero cree un vector");
            return;
        }

        try {
            // Eliminar último elemento
            int index = vector.size() - 1;
            Object removed = vector.remove(index);
            showMessage("Elemento eliminado de la posición " + index + ": " + removed);
        } catch (Exception e) {
            showError("No se pudo eliminar el elemento");
        }
    }

    @FXML
    void sizeOnAction(ActionEvent event) {
        if (vector == null) {
            showError("Primero cree un vector");
            return;
        }

        showMessage("Tamaño del vector: " + vector.size());
    }

    @FXML
    void textfielOnAction(ActionEvent event) {

    }
}
