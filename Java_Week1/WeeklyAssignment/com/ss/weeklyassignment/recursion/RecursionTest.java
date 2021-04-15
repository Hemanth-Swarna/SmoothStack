/**
 * 
 */
package com.ss.weeklyassignment.recursion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author heman
 *
 */
public class RecursionTest {
	
	@Test
	public void testGroupSumClump() {
		assertTrue(Recursion.groupSumClump(0, new int[] { 2, 4, 8 }, 10));
		assertTrue(Recursion.groupSumClump(0, new int[] { 1, 2, 4, 8, 1 }, 14));
		assertFalse(Recursion.groupSumClump(0, new int[] { 2, 4, 4, 8 }, 14));
		assertFalse(Recursion.groupSumClump(0, new int[] { 1, 3, 3, 12 }, 17));
	}
}
