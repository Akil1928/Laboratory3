package domain;

import java.util.Random;

public class Probabilistic {

    // Este es el algoritmo de Rabin-Miller
    public boolean isProbablyPrime(int n, int k) {
        if (n <= 1 || n % 2 == 0) return false;
        if (n == 2 || n == 3) return true;

        int d = n - 1;
        int r = 0;
        while (d % 2 == 0) {
            d /= 2;
            r++;
        }

        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int a = 2 + random.nextInt(n - 3);
            int x = powerMod(a, d, n);
            if (x == 1 || x == n - 1) continue;

            boolean composite = true;
            for (int j = 0; j < r - 1; j++) {
                x = (x * x) % n;
                if (x == n - 1) {
                    composite = false;
                    break;
                }
            }
            if (composite) return false;
        }
        return true;
    }

    private int powerMod(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }

    // Este es el algoritmo de la Paradoja del Cumpleaños
    public double birthdayParadox(int n) {
        if (n < 1 || n > 365) return 0;

        double probability = 1.0;
        for (int i = 1; i < n; i++) {
            probability *= (366 - i) / 365.0;
        }
        return 1 - probability; // Probabilidad de que al menos dos personas compartan cumpleaños
    }

    // Búsqueda aleatoria en un arreglo
    public int[] randomSearch(int[] a, int value, int attempts) {
        Random random = new Random();
        for (int i = 0; i < attempts; i++) {
            int index = random.nextInt(a.length);
            if (a[index] == value) {
                return new int[]{index, i + 1}; // Índice encontrado y número de intentos
            }
        }
        return new int[]{-1, attempts}; // No encontrado dentro del límite de intentos
    }
}