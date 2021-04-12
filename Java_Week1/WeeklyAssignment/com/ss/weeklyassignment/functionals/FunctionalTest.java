/**
 * 
 */
package com.ss.weeklyassignment.functionals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author heman
 *
 */
public class FunctionalTest {

	@Test
	public void testRightMost() {
		Integer[] integers = { 41, 22, 56, 0 };
		Integer[] digits = { 1, 2, 6, 0 };
		Integer[] rint = Functionals.rightmost.function(integers);
		for (int i = 0; i < rint.length; i++) {
			assertEquals(rint[i], digits[i]);
		}
	}

	@Test
	public void testDoubled() {
		Integer[] integers = { 41, 22, 56, 0, -4 };
		Integer[] doubled = { 82, 44, 112, 0, -8 };
		Integer[] dint = Functionals.doubled.function(integers);
		for (int i = 0; i < dint.length; i++) {
			assertEquals(dint[i], doubled[i]);
		}
	}

	@Test
	public void testRemoveX() {
		String[] strings = { "Excellent", "day", "at", "New", "Mexico", "in", "x" };
		String[] prunedstrings = { "Ecellent", "day", "at", "New", "Meico", "in", "" };
		String[] stringswithoutX = Functionals.removeX.function(strings);
		for (int i = 0; i < stringswithoutX.length; i++) {
			assertEquals(stringswithoutX[i], prunedstrings[i]);
		}
	}

}
