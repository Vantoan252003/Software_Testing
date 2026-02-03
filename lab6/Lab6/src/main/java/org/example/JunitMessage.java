package org.example;

/**
 * Class for demonstrating exception testing with JUnit 4
 * Used in BÀI 1 - Test exception with @Test(expected)
 */
public class JunitMessage {

    /**
     * Divides two integers
     * @param a the dividend
     * @param b the divisor
     * @return the result of a / b
     * @throws ArithmeticException if b is 0
     */
    public int divide(int a, int b) {
        return a / b;
    }
}
