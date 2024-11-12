package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a set of integers and provides various operations 
 * such as adding, removing, and checking for elements, as well as performing 
 * set operations like union, intersection, difference, and complement.
 * 
 * javaDoc comments referenced by ChatGPT
 * 
 * @author joshd
 */
public class IntegerSet {
    /**
     * A list that holds the elements of the set.
     */
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor that initializes an empty set.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the set with a provided list of integers.
     * 
     * @param set The list of integers to initialize the set with.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Returns the set of integers.
     * 
     * @return A list of integers representing the set.
     */
    public List<Integer> getSet() {
        return set;
    }

    /**
     * Removes all elements from the set, leaving it empty.
     */
    public void clear() {
        if (!set.isEmpty()) {
            set.clear();
        }
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return The size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if this set is equal to another object.
     * 
     * @param o The object to compare to.
     * @return true if the two sets are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IntegerSet otherSet = (IntegerSet) o;

        if (this.getSet().size() != otherSet.getSet().size()) {
            return false;
        }

        return this.getSet().containsAll(otherSet.getSet()) && otherSet.getSet().containsAll(this.getSet());
    }

    /**
     * Checks if the set contains a specified value.
     * 
     * @param value The integer value to check for.
     * @return true if the value is in the set, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     * 
     * @return The largest integer in the set.
     * @throws IntegerSetException If the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is currently empty.");
        }
        return set.get(set.size() - 1);
    }

    /**
     * Returns the smallest element in the set.
     * 
     * @return The smallest integer in the set.
     * @throws IntegerSetException If the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is currently empty.");
        }
        return set.get(0);
    }

    /**
     * Adds an element to the set if it is not already present, and sorts the set.
     * 
     * @param item The integer to add to the set.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
            set.sort(null);
        }
    }

    /**
     * Removes an element from the set.
     * 
     * @param item The integer to remove from the set.
     * @throws IntegerSetException If the set is empty or does not contain the element.
     */
    public void remove(int item) throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is currently empty.");
        } else if (!set.contains(item)) {
            return;
        } else {
            set.remove((Integer) item);
        }
    }

    /**
     * Performs the union of the current set with another set.
     * Adds all elements from the other set that are not already in this set, then sorts the set.
     * 
     * @param intSetb The other set to union with.
     */
    public void union(IntegerSet intSetb) {
        if (intSetb.isEmpty()) {
            return;
        } else {
            List<Integer> intList = new ArrayList<>(intSetb.getSet());
            for (Integer x : intList) {
                if (!set.contains(x)) {
                    set.add(x);
                }
            }
            set.sort(null);
        }
    }

    /**
     * Performs the intersection of the current set with another set.
     * Keeps only the elements that are present in both sets.
     * 
     * @param intSetb The other set to intersect with.
     */
    public void intersect(IntegerSet intSetb) {
        if (intSetb.isEmpty()) {
            return;
        } else {
            List<Integer> intList = new ArrayList<>(intSetb.getSet());
            List<Integer> intersectList = new ArrayList<>();
            for (Integer x : intList) {
                if (set.contains(x)) {
                    intersectList.add(x);
                }
            }
            set.clear();
            set.addAll(intersectList);
        }
    }

    /**
     * Performs the difference operation between the current set and another set.
     * Removes all elements that are also in the other set.
     * 
     * @param intSetb The other set to subtract from this set.
     */
    public void diff(IntegerSet intSetb) {
        if (!intSetb.isEmpty()) {
            set.removeAll(intSetb.getSet());
        }
    }

    /**
     * Performs the complement operation between the current set and another set.
     * Keeps only the elements in this set that are also in the other set.
     * 
     * @param intSetb The other set to compare with.
     */
    public void complement(IntegerSet intSetb) {
        if (!intSetb.isEmpty()) {
            set.retainAll(intSetb.getSet());
        }
    }

    /**
     * Checks if the set is empty.
     * 
     * @return true if the set is empty, false otherwise.
     */
    boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return A string representation of the set.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
