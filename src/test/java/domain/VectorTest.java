package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void vectorTest() {
        // Crear vector de tamaño 50
        Vector vector = new Vector(50);

        // Llenar el vector con valores aleatorios
        for(int i = 0; i < 50; i++){
            vector.add(util.Utility.random(50));
        }

        // Mostrar contenido sin ordenar
        System.out.println("Vector content not sorted: " + util.Utility.show(vector.getData()));

        // Ordenar el vector
        vector.sort();
        System.out.println("Vector content sorted: " + util.Utility.show(vector.getData()));

        // Probar métodos básicos
        System.out.println("Vector size: " + vector.size());
        System.out.println(vector.isEmpty() ? "Vector is empty" : "Vector is not empty");

        // Pruebas de métodos adicionales
        // Agregar elementos en posiciones específicas
        vector.add(10, 19);
        vector.add(5, 24);
        vector.add(0, 18);
        System.out.println("Vector after adding elements at specific positions: " + vector);

        // Probar contains
        System.out.println("Contains 100: " + vector.contains(10));
        System.out.println("Contains 999: " + vector.contains(15));

        // Probar indexOf
        System.out.println("Index of 100: " + vector.indexOf(43));

        // Probar remove
        Object removedByIndex = vector.remove(10);
        System.out.println("Removed element at index 10: " + removedByIndex);

        Object removedByValue = vector.remove(2);
        System.out.println("Removed 200: " + removedByValue);

        // Mostrar contenido final
        System.out.println("Final vector content: " + vector);

        // Prueba de clear
        vector.clear();
        assertTrue(vector.isEmpty(), "Vector should be empty after clear");
    }

    @Test
    void testSpecificOperations() {
        Vector vector = new Vector(10);

        // Agregar elementos
        vector.add(40);
        vector.add(5, 81);
        vector.add(0, 70);

        // Eliminar elemento de la posición 10
        vector.remove(10);

        // Eliminar elemento de la posición 5
        vector.remove(5);

        System.out.println("Vector after specific operations: " + vector);
    }
}