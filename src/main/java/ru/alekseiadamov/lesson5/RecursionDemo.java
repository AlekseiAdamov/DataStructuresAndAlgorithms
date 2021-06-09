package ru.alekseiadamov.lesson5;

public class RecursionDemo {
    public static void main(String[] args) {
        countdown(5);

        System.out.println(factorial(6));

        double n = 2;
        int power = 7;
        System.out.printf("%f to the power of %d is %f.\n", n, power, pow(n, power));

        power = -4;
        System.out.printf("%f to the power of %d is %f.\n", n, power, pow(n, power));
    }

    private static void countdown(int n) {
        System.out.println(n);
        if (n == 1) {
            return;
        }
        countdown(n - 1);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static double pow(double n, int power) {
        if (power == 0) {
            return 1;
        }
        if (power > 0) {
            return n * pow(n, power - 1);
        }
        return 1 / (n * pow(n, -power - 1));
    }
}
