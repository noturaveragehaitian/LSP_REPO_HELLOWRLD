package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author joshd
 */


public class IntegerSet {
	/**
	 * This program takes in a list of integers and completes various functions with it
	 * some functions require a second list of integers in order to complete their task
	 */
	
	/**
	 * Functions that need elements from a list to operate will check
	 * if the list is empty before moving on to their tasks
	 */
	private List<Integer> set = new ArrayList<Integer>();
	
	public IntegerSet() {
		
	}
	
	public IntegerSet(ArrayList<Integer>set) {
	/**
	 * IntegerSet() Initializes the list. takes in @param 
	 */
		this.set = set;
	}

	public List<Integer> getSet() {
		/**
		 *  getSet() returns the set, used for casting a list instead of ArrayList
		 *  reference from ChatGPT
		 */
		return set;
	}
	
	public void clear() {
		/**
		 *  clear() removes every element in the set
		 */
		if(set.isEmpty()) {
			return;
		} else {
			set.clear();
		}
	}
	
	public int length() {
		return set.size();
	}
	
	@Override
	public boolean equals(Object o) {
		/**
		 * equals() takes in @param, returns @return
		 * checks if 2 lists are of the same data type,
		 * then compares all elements in both lists
		 * 
		 * reference by ChatGPT
		 */
		
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
	
	public boolean contains(int value) {
		/**
		 * contains() takes in @param
		 * returns @return
		 */
		return (set.contains(value));
	}
	
	public int largest() {
		/**
		 * largest() returns @return, the largest element in the set
		 */
		return set.getLast();
	}
	
	public int smallest() {
		/**
		 * smallest() returns @return, the smallest element in the set
		 */
		return set.getFirst();
	}
	
	public void add(int item) {
		/**
		 * add() takes in @param
		 * prevents duplicate elements
		 * adds the element to the list and sorts the list
		 */
		if(set.contains(item)) {
			return;
		} else {
			set.add(item);
			set.sort(null);
		}
	}
	
	public void remove(int item) {
		/**
		 * remove() takes in @param
		 * removes an element if the list is not empty
		 * or if the list contains the element
		 */
		if(!set.contains(item) || set.isEmpty()) {
			return;
		} else {
			set.remove(item);
		}
	}
	
	public void union(IntegerSet intSetb) {
		/**
		 * union() takes in @param
		 * adds all elements from another list that the primary list does not contain
		 * sorts when finished
		 */
		if(intSetb.isEmpty()) {
			return;
		} else {
			List<Integer> intList = new ArrayList<>(intSetb.getSet());
			for(Integer x = 0; x < intList.size(); x++) {
				if(!set.contains(intList.get(x))) {
					set.add(intList.get(x));
				}
			}
			set.sort(null);
		}
	}
	
	public void intersect(IntegerSet intSetb) {
		/**
		 * intersect() takes in @param
		 * puts all values that are in both lists being compared
		 * and puts them into intersectList
		 * once finished, primary set is cleared and adds all elements in 
		 * intersectList
		 */
		if(intSetb.isEmpty()) {
			return;
		} else {
			List<Integer> intList = new ArrayList<>(intSetb.getSet());
			List<Integer> intersectList = new ArrayList<Integer>();
			for(Integer x = 0; x < intList.size(); x++) {
				if(set.contains(intList.get(x))) {
					intersectList.add(intList.get(x));
				}
			}
			set.clear();
			for(Integer y = 0; y < intersectList.size(); y++) {
				set.add(intersectList.get(y));
			}
		}
	}
	
	public void diff(IntegerSet intSetb) {
		/**
		 * diff() takes in @param
		 * removes all elements in set that intSetb contains
		 */
		if(intSetb.isEmpty()) {
			return;
		} else {
			List<Integer> intList = new ArrayList<>(intSetb.getSet());
			set.removeAll(intList);
		}
	}
	
	public void complement(IntegerSet intSetb) {
		/**
		 * complement() takes in @param
		 * removes all elements in set that intSetb does not contain
		 */
		if(intSetb.isEmpty()) {
			return;
		} else {
			for(Integer x = 0; x < set.size(); x++) {
				if(!intSetb.contains(set.get(x))) {
					set.remove(set.get(x));
				}
			}
		}
	}
	
	boolean isEmpty() {
		/**
		 * isEmpty() returns @return
		 */
		return set.isEmpty();
	}
	
	@Override
	public String toString() {
		/**
		 * toString() appends all elements in a set to a StringBuilder
		 * returns @return
		 */
		StringBuilder result = new StringBuilder();
        for (Integer i = 0; i < set.size(); i++) {
            result.append(set.get(i) + " ");
        }
        return result.toString();
	}
}
