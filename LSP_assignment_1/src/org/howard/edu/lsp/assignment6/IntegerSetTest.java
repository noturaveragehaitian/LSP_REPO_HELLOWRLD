package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerSetTest {
	/**
	 * Test cases referenced by ClaudeAI
	 */
	
	IntegerSet set;
	/**
	 * 
	 * @throws Exception
	 */

	@BeforeEach
	void setUp() throws Exception {
		set = new IntegerSet();
	}

	@Test
	@DisplayName("Test case for GetSet. Checks for correct list length and contents after initializing a set")
	void testGetSet() {
		set.add(1);
		set.add(2);
		set.add(3);
		assertEquals(3, set.length());
		assertTrue(set.contains(1));
		assertTrue(set.contains(2));
		assertTrue(set.contains(3));
	}

	@Test
	@DisplayName("Test case for clear. Tests for an empty list after emptying list")
	void testClearWithElements() {
		set.add(1);
		set.add(2);
		set.clear();
		assertEquals(0, set.length());
		assertTrue(set.isEmpty());
	}

	@Test
	@DisplayName("Test case for Length. Checks for correct list length after adding elements")
	void testLength() {
		assertEquals(0, set.length());
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		assertEquals(4, set.length());
	}

	@Test
	@DisplayName("Test case for Equals. Checks for correct list contents")
	void testEqualsObject() {
		IntegerSet otherSet = new IntegerSet();
		set.add(1);
		set.add(2);
		otherSet.add(1);
		otherSet.add(2);
		assertTrue(set.equals(otherSet));
		
		otherSet.add(3);
		assertFalse(set.equals(otherSet));
	}
	
	@DisplayName("Test case for Equals. Checks for comparing correct data types")
	void testEqualsOtherObject() {
		String otherSet = "[1, 2]";
		set.add(1);
		set.add(2);
		assertFalse(set.equals(otherSet));
	}
	

	@Test
	@DisplayName("Test case for Contains. Checks for elements in or not in a set")
	void testContains() {
		set.add(1);
		set.add(2);
		assertTrue(set.contains(1));
		assertTrue(set.contains(2));
		assertFalse(set.contains(3));
	}

	@Test
	@DisplayName("Test case for Largest. Checks for largest element in a set")
	void testLargest() {
		set.add(1);
		set.add(2);
		set.add(3);
		try {
			assertEquals(3, set.largest());
		} catch (IntegerSetException e) {
			fail("testLargest failed");
		}
	}
	
	@Test
	@DisplayName("Test case for Largest, with an empty set. Expects IntegerSetException to be thrown")
	void testLargestWithEmptyList() {
		assertThrows(IntegerSetException.class, () -> {
			set.largest();
		});
	}

	@Test
	@DisplayName("Test case for Smallest. Checks for smallest element in a set")
	void testSmallest() {
		set.add(1);
		set.add(2);
		set.add(3);
		try {
			assertEquals(1, set.smallest());
		} catch (IntegerSetException e) {
			fail("testSmallest failed");
		}
	}
	
	@Test
	@DisplayName("Test case for Smallest, with an empty set. Expects IntegerSetException to be thrown")
	void testSmallestWithEmptyList() {
		assertThrows(IntegerSetException.class, () -> {
			set.smallest();
		});
	}

	@Test
	@DisplayName("Test case for Add. Expects only unique elements to be in the set")
	void testAdd() {
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(1);
		assertTrue(set.contains(1));
		assertTrue(set.contains(2));
		assertEquals(2, set.length());
	}

	@Test
	@DisplayName("Test case for Remove. Checks for removed element to not be in the set, and set size to adjust accordingly")
	void testRemove(){
		set.add(1);
		set.add(2);
		try {
			set.remove(1);
		} catch (IntegerSetException e) {
			fail("testRemove failed");
		}
		assertFalse(set.contains(1));
		assertTrue(set.contains(2));
		assertEquals(1, set.length());
	}
	
	@Test
	@DisplayName("Test case for Remove, with an empty set. Expects IntegerSetException to be thrown")
	void testRemoveFromEmptyList() {
		assertThrows(Exception.class, () -> {
			set.remove(1);
		});
	}

	@Test
	@DisplayName("Test case for Union. Checks that set adds all elements in otherSet that arent already in set.")
	void testUnion() {
		IntegerSet otherSet = new IntegerSet();
		set.add(1);
		set.add(2);
		otherSet.add(2);
		otherSet.add(3);
		set.union(otherSet);
		assertTrue(set.contains(1));
		assertTrue(set.contains(2));
		assertTrue(set.contains(3));
		assertEquals(3, set.length());
	}

	@Test
	@DisplayName("Test case for Intersect. Checks that set only has what elements both itself and otherSet has")
	void testIntersect() {
		IntegerSet otherSet = new IntegerSet();
		set.add(1);
		set.add(2);
		otherSet.add(2);
		otherSet.add(3);
		set.intersect(otherSet);
		assertTrue(set.contains(2));
		assertFalse(set.contains(1));
		assertFalse(set.contains(3));
		assertEquals(1, set.length());
	}

	@Test
	@DisplayName("Test case for Diff. Checks that set removes all elements that are in both itself and otherSet")
	void testDiff() {
		IntegerSet otherSet = new IntegerSet();
		set.add(1);
		set.add(2);
		otherSet.add(2);
		otherSet.add(3);
		set.diff(otherSet);
		assertTrue(set.contains(1));
		assertFalse(set.contains(2));
		assertFalse(set.contains(3));
		assertEquals(1, set.length());
	}

	@Test
	@DisplayName("Test case for Complement. Checks that set will only contain elements that otherSet has")
	void testComplement() {
		IntegerSet otherSet = new IntegerSet();
		set.add(1);
		set.add(2);
		set.add(3);
		otherSet.add(1);
		otherSet.add(2);
		set.complement(otherSet);
		assertFalse(set.contains(3));
		assertTrue(set.contains(2));
		assertTrue(set.contains(1));
		assertEquals(2, set.length());
	}

	@Test
	@DisplayName("Test case for IsEmpty. Checks the state of a list and correctly confirms when empty or not")
	void testIsEmpty() {
		assertTrue(set.isEmpty());
		set.add(1);
		assertFalse(set.isEmpty());
	}

	@Test
	@DisplayName("Test case for ToString. Checks that the string conversion is done correctly")
	void testToString() {
		set.add(1);
		set.add(2);
		String expected = "[1, 2]";
		assertEquals(expected, set.toString());
	}
}
