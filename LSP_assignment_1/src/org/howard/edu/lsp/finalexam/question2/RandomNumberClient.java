package org.howard.edu.lsp.finalexam.question2;

/**
 * Client class demonstrating the usage of RandomNumberService
 * 
 * References by Claude AI
 */
public class RandomNumberClient {
    /**
     * Main method to demonstrate RandomNumberService functionality
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        RandomNumberService service = RandomNumberService.getInstance();
        
        System.out.println("Java Random: " + service.getRandomUsingJava());
        System.out.println("Custom Random: " + service.getRandomUsingCustom());
        
        RandomNumberService anotherService = RandomNumberService.getInstance();
        System.out.println("Same instance? " + (service == anotherService));
    }
}