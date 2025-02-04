package com.example;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    // For division, we return an integer result. You can adjust error handling as needed.
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Addition of 5 and 3: " + calc.add(5, 3));
        System.out.println("Subtraction of 5 from 10: " + calc.subtract(10, 5));
        System.out.println("Multiplication of 4 and 6: " + calc.multiply(4, 6));
        System.out.println("Division of 20 by 4: " + calc.divide(20, 4));
    }
}

