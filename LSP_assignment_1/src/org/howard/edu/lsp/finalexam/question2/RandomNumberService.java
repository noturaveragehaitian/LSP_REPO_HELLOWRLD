package org.howard.edu.lsp.finalexam.question2;

import java.util.Random;

/**
 * A singleton service that provides different implementations of random number generation
 * This service ensures only one instance exists and provides two different
 * approaches to generating random positive integers
 * 
 * References by Claude AI
 */
public class RandomNumberService {
    private static RandomNumberService instance = null;
    private Random javaRandom = new Random();
    
    /**
     * Private constructor to prevent instantiation
     */
    private RandomNumberService() {}
    
    /**
     * Returns the singleton instance of RandomNumberService
     * Creates a new instance if one doesn't exist
     * 
     * @return The singleton instance of RandomNumberService
     */
    public static RandomNumberService getInstance() {
        if (instance == null) {
            instance = new RandomNumberService();
        }
        return instance;
    }
    
    /**
     * Generates a random positive integer using Java's Random class
     * 
     * @return A positive random integer
     */
    public int getRandomUsingJava() {
        return Math.abs(javaRandom.nextInt()) + 1;
    }
    
    /**
     * Generates a random positive integer using system timestamp
     * 
     * @return A positive random integer
     */
    public int getRandomUsingCustom() {
        long timestamp = System.currentTimeMillis();
        return (int)(Math.abs(timestamp % Integer.MAX_VALUE)) + 1;
    }
}