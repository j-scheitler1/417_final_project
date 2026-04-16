package com.example;

public class Calculator {
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public double average(int... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("At least one value is required");
        }

        int sum = 0;
        for (int value : values) {
            sum = add(sum, value);
        }

        return (double) sum / values.length;
    }
}
