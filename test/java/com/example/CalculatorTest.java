package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void addWorks() {
        Calculator c = new Calculator();
        assertEquals(5, c.add(2, 3));
    }

    @Test
    public void subtractWorks() {
        Calculator c = new Calculator();
        assertEquals(4, c.subtract(9, 5));
    }

    @Test
    public void multiplyWorks() {
        Calculator c = new Calculator();
        assertEquals(12, c.multiply(3, 4));
    }

    @Test
    public void divideWorks() {
        Calculator c = new Calculator();
        assertEquals(5, c.divide(20, 4));
    }

    @Test
    public void divideByZeroThrowsException() {
        Calculator c = new Calculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> c.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void averageWorks() {
        Calculator c = new Calculator();
        assertEquals(85.0, c.average(80, 90, 85), 0.001);
    }
}
