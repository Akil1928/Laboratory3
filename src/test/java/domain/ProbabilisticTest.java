package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProbabilisticTest {

    @Test
    void isProbablyPrime() {
        Probabilistic p = new Probabilistic();
        int[] testNumbers = {29341, 131071, 214748, 483647, 2147483647};

        for (int num : testNumbers) {
            boolean result = p.isProbablyPrime(num, 5); // 5 iteraciones de prueba
            System.out.println("Number " + num + " is " + (result ? "probably prime" : "composite"));
        }
    }

    @Test
    void birthdayParadox() {
        Probabilistic p = new Probabilistic();
        int[] populations = {45, 23, 37, 15, 70};

        for (int n : populations) {
            double probability = p.birthdayParadox(n);
            System.out.println("For " + n + " people, probability of shared birthday: " + probability);
        }
    }

    @Test
    void randomSearch() {
        Probabilistic p = new Probabilistic();
        int[] a = new int[100];
        util.Utility.fill(a);

        System.out.println("Array content:\n" + util.Utility.show(a));

        int value = util.Utility.random(99);
        int[] result = p.randomSearch(a, value, 50);

        System.out.println(
                result[0] != -1
                        ? "Item [" + value + "] found in index: " + result[0] + ". Attempts: " + result[1]
                        : "Item [" + value + "] not found. Max attempts: " + result[1]
        );
    }
}
