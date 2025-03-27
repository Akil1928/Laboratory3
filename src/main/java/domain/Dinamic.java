package domain;

public class Dinamic {
    private static long[] almFact;
    private static long[] almFibo;
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n no puede ser negativo");
        }

        if (n == 0) return 0;
        if (n == 1) return 1;

        almFibo = new long[n + 1];
        almFibo[0] = 0;
        almFibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            almFibo[i] = almFibo[i - 1] + almFibo[i - 2];
        }

        return almFibo[n];
    }
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n no puede ser negativo");
        }

        if (n == 0) return 1;

        almFact = new long[n + 1];
        almFact[0] = 1;

        for (int i = 1; i <= n; i++) {
            almFact[i] = i * almFact[i - 1];
        }

        return almFact[n];
    }
}
