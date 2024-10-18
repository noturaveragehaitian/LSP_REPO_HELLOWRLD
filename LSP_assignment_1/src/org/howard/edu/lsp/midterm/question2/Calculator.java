package org.howard.edu.lsp.midterm.question2;

// referencing ChatGPT
public class Calculator {
	// sum method to add 2 ints
	public static int sum(int a, int b) {
        return a + b;
    }

    // sum method to add two double values
    public static double sum(double a, double b) {
        return a + b;
    }

    // Sum method to add all elements in an array of integers
    public static int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
