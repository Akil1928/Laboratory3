package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void vectorTest() {
        // a. Crear e instanciar un vector de tamaño 50
        Vector vector = new Vector(50);

        // b. Llenar el vector con valores aleatorios
        util.Utility.fill(vector.getData());
        for (int i = 0; i < 50; i++) {
            vector.add(util.Utility.random(50));
        }
        System.out.println("Vector content not sorted: " + util.Utility.show(vector.getData()));

        // c. Ordenar el vector con el método sort y mostrar el contenido
        vector.sort();
        System.out.println("Vector content sorted: " + util.Utility.show(vector.getData()));

        // d. Probar los métodos size e isEmpty
        System.out.println("Vector size: " + vector.size());
        System.out.println(vector.isEmpty() ? "Vector is empty" : "Vector is not empty");

        // e. Agregar elementos en las posiciones 10, 5 y 0
        vector.addAt(10, util.Utility.random(100));
        vector.addAt(5, util.Utility.random(100));
        vector.addAt(0, util.Utility.random(100));
        System.out.println("\n Vector after adding elements at 10, 5, and 0: " + util.Utility.show(vector.getData()));

        // f. Utilizar un bucle for hasta 30 para probar el método contains
        for (int i = 0; i < 30; i++) {
            int randomValue = util.Utility.random(100);
            System.out.println("Vector contains " + randomValue + ": " + vector.contains(randomValue));
        }

        // g. Eliminar el elemento en la posición 10 y agregar 81 en la posición 10
        vector.remove(10);
        vector.addAt(10, 81);
        System.out.println("\n Vector after removing and adding at position 10: " + util.Utility.show(vector.getData()));

        // h. Eliminar el elemento en la posición 5 y mostrar el contenido
        vector.remove(5);
        System.out.println("\n Vector after removing element at position 5: " + util.Utility.show(vector.getData()));

        // i. Agregar 40 en la posición 5, eliminar en la posición 0, agregar 70 en la posición 0
        vector.addAt(5, 40);
        vector.remove(0);
        vector.addAt(0, 70);
        System.out.println("\n Vector after modifications (40 at 5, remove 0, add 70 at 0): " + util.Utility.show(vector.getData()));

        // j. Usar un bucle for hasta 30 para probar el método remove
        for (int i = 0; i < 30; i++) {
            int randomValue = util.Utility.random(50);
            vector.remove(randomValue);
        }

        // k. Mostrar el contenido final del vector
        System.out.println("\n Final vector content: " + util.Utility.show(vector.getData()));
    }
}
