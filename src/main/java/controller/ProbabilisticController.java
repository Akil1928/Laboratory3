package controller;

import domain.Probabilistic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Random;

public class ProbabilisticController {

    private final Probabilistic probabilistic = new Probabilistic();
    private int[] searchArray;

    @FXML
    private ComboBox<String> selectProbabilistic;

    @FXML
    private TextArea textAreaP;

    @FXML
    private TextField textFieldP;

    @FXML
    public void initialize() {
        // Configurar ComboBox
        selectProbabilistic.getItems().addAll(
                "Test de Primalidad",
                "Paradoja del Cumpleaños",
                "Búsqueda Aleatoria"
        );
        selectProbabilistic.setValue("Test de Primalidad");

        // Inicializar array para búsqueda
        initializeSearchArray();
    }

    private void initializeSearchArray() {
        searchArray = new int[100];
        Random rand = new Random();
        for (int i = 0; i < searchArray.length; i++) {
            searchArray[i] = rand.nextInt(1000);
        }
        textAreaP.appendText("Array de búsqueda inicializado (100 elementos 0-999)\n");
    }

    @FXML
    void calculateOnAction(ActionEvent event) {
        String selected = selectProbabilistic.getValue();
        String input = textFieldP.getText().trim();

        try {
            switch (selected) {
                case "Test de Primalidad":
                    int number = Integer.parseInt(input);
                    boolean isPrime = probabilistic.isProbablyPrime(number, 5);
                    textAreaP.appendText(String.format("¿Es %d primo? %s\n", number, isPrime ? "Sí" : "No"));
                    break;

                case "Paradoja del Cumpleaños":
                    int people = Integer.parseInt(input);
                    double prob = probabilistic.birthdayParadox(people);
                    textAreaP.appendText(String.format("Para %d personas: %.2f%% de coincidencia\n", people, prob * 100));
                    break;

                case "Búsqueda Aleatoria":
                    int value = Integer.parseInt(input);
                    int[] result = probabilistic.randomSearch(searchArray, value, 50);
                    textAreaP.appendText(result[0] != -1 ?
                            String.format("Valor %d encontrado en posición %d (intento %d)\n", value, result[0], result[1]) :
                            String.format("Valor %d no encontrado en 50 intentos\n", value)
                    );
                    break;
            }
        } catch (NumberFormatException e) {
            textAreaP.appendText("Error: Ingrese un número válido\n");
        }
    }

    @FXML
    void cleanPOnAction(ActionEvent event) {
        textAreaP.clear();
        textFieldP.clear();
    }

    @FXML
    void textFieldPOnAction(ActionEvent event) {
        calculateOnAction(event);
    }
}