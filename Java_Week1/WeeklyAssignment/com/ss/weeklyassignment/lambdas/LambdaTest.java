/**
 * 
 */
package com.ss.weeklyassignment.lambdas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author heman
 *
 */
public class LambdaTest {

	@Test
	public void testIsOdd() {
		assertFalse(AssignmentOne.isOdd.input(4));
		assertTrue(AssignmentOne.isOdd.input(3));
		assertFalse(AssignmentOne.isOdd.input(-4));
		assertTrue(AssignmentOne.isOdd.input(-3));
	}
	
	@Test
	public void testIsPrime() {
		assertFalse(AssignmentOne.isPrime.input(1));
		assertTrue(AssignmentOne.isPrime.input(2));
		assertFalse(AssignmentOne.isPrime.input(0));
		assertTrue(AssignmentOne.isPrime.input(71));
		assertFalse(AssignmentOne.isPrime.input(-71));
	}
	
	@Test
	public void testIsPalindrome() {
		assertTrue(AssignmentOne.isPalindrome.input(123454321));
		assertTrue(AssignmentOne.isPalindrome.input(343));
		assertTrue(AssignmentOne.isPalindrome.input(3));
		assertFalse(AssignmentOne.isPalindrome.input(5678));
		assertFalse(AssignmentOne.isPalindrome.input(-3));
	}
}
