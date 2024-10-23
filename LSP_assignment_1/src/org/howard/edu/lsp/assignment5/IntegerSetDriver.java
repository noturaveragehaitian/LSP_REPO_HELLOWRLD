package org.howard.edu.lsp.assignment5;

public class IntegerSetDriver {
	public static void main(String[] args) {
		 // Test default constructor and adding elements
        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(3);
        setA.add(5);
        setA.add(7);
        setA.add(9);
        
        System.out.println("Set A: " + setA);
        System.out.println("Length of Set A: " + setA.length());
        System.out.println("Largest element in Set A: " + setA.largest());
        System.out.println("Smallest element in Set A: " + setA.smallest());
        System.out.println();

        // Test another set with initial elements and equality
        IntegerSet setB = new IntegerSet();
        setB.add(1);
        setB.add(3);
        setB.add(5);
        
        System.out.println("Set B: " + setB);
        System.out.println("Is Set A equal to Set B? " + setA.equals(setB)); // False, different sizes
        setB.add(7);
        setB.add(9);
        System.out.println("Updated Set B: " + setB);
        System.out.println("Is Set A equal to Set B now? " + setA.equals(setB)); // True, same elements
        System.out.println();

        // Test union
        IntegerSet setC = new IntegerSet();
        setC.add(10);
        setC.add(3);
        setC.add(15);
        System.out.println("Set C: " + setC);
        
        setA.union(setC);
        System.out.println("Union of Set A and Set C: " + setA);  // Should contain all elements from both sets
        System.out.println();

        // Test intersection
        IntegerSet setD = new IntegerSet();
        setD.add(3);
        setD.add(5);
        setD.add(15);
        System.out.println("Set D: " + setD);
        
        setA.intersect(setD);
        System.out.println("Intersection of Set A and Set D: " + setA);  // Should contain only common elements (3, 5)
        System.out.println();

        // Test difference
        IntegerSet setE = new IntegerSet();
        setE.add(5);
        setE.add(15);
        System.out.println("Set E: " + setE);
        
        setD.diff(setE);
        System.out.println("Difference between Set D and Set E: " + setD);  // Should remove elements present in both (5, 15)
        System.out.println();

        // Test complement
        IntegerSet setF = new IntegerSet();
        setF.add(2);
        setF.add(3);
        setF.add(5);
        System.out.println("Set F: " + setF);
        
        setF.complement(setE);
        System.out.println("Complement of Set F with respect to Set E: " + setF);  // Should retain only elements not in Set E
        System.out.println();

        // Test contains
        System.out.println("Does Set A contain 3? " + setA.contains(3)); // Should return true
        System.out.println("Does Set A contain 10? " + setA.contains(10)); // Should return false

        // Test clear
        setA.clear();
        System.out.println("After clearing Set A: " + setA);
        System.out.println("Is Set A empty? " + setA.isEmpty());
	}

}
