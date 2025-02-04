package com.example;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int failedTests = 0;

        // Test 1: Addition
        if (calc.add(2, 3) != 5) {
            System.out.println("Test 1 Failed: 2 + 3 should equal 5");
            failedTests++;
        }

        // Test 2: Subtraction
        if (calc.subtract(10, 4) != 6) {
            System.out.println("Test 2 Failed: 10 - 4 should equal 6");
            failedTests++;
        }

        // Test 3: Multiplication
        if (calc.multiply(3, 7) != 21) {
            System.out.println("Test 3 Failed: 3 * 7 should equal 21");
            failedTests++;
        }

        // Test 4: Division
        try {
            if (calc.divide(20, 5) != 4) {
                System.out.println("Test 4 Failed: 20 / 5 should equal 4");
                failedTests++;
            }
        } catch (Exception e) {
            System.out.println("Test 4 Failed: Exception thrown during division");
            failedTests++;
        }

        // Test 5: Division by zero
        try {
            calc.divide(10, 0);
            System.out.println("Test 5 Failed: Division by zero should throw exception");
            failedTests++;
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            System.out.println("Test 5 Failed: Unexpected exception type");
            failedTests++;
        }

        if (failedTests == 0) {
            System.out.println("All tests passed.");
            System.exit(0);
        } else {
            System.out.println(failedTests + " test(s) failed.");
            System.exit(1);
        }
    }
}
