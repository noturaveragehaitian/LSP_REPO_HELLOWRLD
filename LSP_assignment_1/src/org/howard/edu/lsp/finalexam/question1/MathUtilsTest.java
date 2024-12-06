package org.howard.edu.lsp.finalexam.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for MathUtils implementation
 * Tests factorial, prime number checking, and GCD calculations
 * 
 * References by Claude AI
 */
public class MathUtilsTest {
    private MathUtils mathUtils;
    
    /**
     * Sets up a new MathUtils instance before each test
     */
    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }
    
    /**
     * Tests factorial calculation with zero input
     */
    @Test
    void testFactorial_ZeroInput_ReturnsOne() {
        assertEquals(1, mathUtils.factorial(0));
    }
    
    /**
     * Tests factorial calculation with input of one
     */
    @Test
    void testFactorial_OneInput_ReturnsOne() {
        assertEquals(1, mathUtils.factorial(1));
    }
    
    /**
     * Tests factorial calculation with positive input
     */
    @Test
    void testFactorial_PositiveInput_ReturnsCorrectValue() {
        assertEquals(120, mathUtils.factorial(5));
    }
    
    /**
     * Tests factorial calculation with negative input
     * Expects IllegalArgumentException
     */
    @Test
    void testFactorial_NegativeInput_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            mathUtils.factorial(-1);
        });
    }
    
    /**
     * Tests prime number checking with a prime number
     */
    @Test
    void testIsPrime_PrimeNumber_ReturnsTrue() {
        assertTrue(mathUtils.isPrime(17));
    }
    
    /**
     * Tests prime number checking with a non-prime number
     */
    @Test
    void testIsPrime_NonPrimeNumber_ReturnsFalse() {
        assertFalse(mathUtils.isPrime(4));
    }
    
    /**
     * Tests prime number checking with numbers less than or equal to one
     */
    @Test
    void testIsPrime_OneOrLess_ReturnsFalse() {
        assertFalse(mathUtils.isPrime(1));
        assertFalse(mathUtils.isPrime(0));
        assertFalse(mathUtils.isPrime(-1));
    }
    
    /**
     * Tests GCD calculation with positive numbers
     */
    @Test
    void testGcd_PositiveNumbers_ReturnsCorrectValue() {
        assertEquals(6, mathUtils.gcd(24, 18));
    }
    
    /**
     * Tests GCD calculation when one input is zero
     */
    @Test
    void testGcd_OneZeroInput_ReturnsNonZeroValue() {
        assertEquals(15, mathUtils.gcd(15, 0));
        assertEquals(15, mathUtils.gcd(0, 15));
    }
    
    /**
     * Tests GCD calculation with negative numbers
     */
    @Test
    void testGcd_NegativeNumbers_ReturnsPositiveGcd() {
        assertEquals(6, mathUtils.gcd(-24, 18));
        assertEquals(6, mathUtils.gcd(24, -18));
        assertEquals(6, mathUtils.gcd(-24, -18));
    }
    
    /**
     * Tests GCD calculation when both inputs are zero
     * Expects IllegalArgumentException
     */
    @Test
    void testGcd_BothZero_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            mathUtils.gcd(0, 0);
        });
    }
}