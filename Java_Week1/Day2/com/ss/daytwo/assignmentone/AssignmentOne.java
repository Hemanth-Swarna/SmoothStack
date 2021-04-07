/**
 * 
 */
package com.ss.daytwo.assignmentone;

/**
 * @author heman
 *
 */
public class AssignmentOne {

	/**
	 * @param args
	 */
	
	// Converting string arguments into ints while handling exceptions for wrong inputs. We then sum up the ints.
	public static void main(String[] args) {

		int sum = 0;

		for (String s : args) {
			try {
				sum += Integer.parseInt(s);
			} catch (NumberFormatException e) {
				System.out.println(s + " is an invalid entry");
			}
		}
		
		System.out.println("This is the sum: " + sum);

	}
}
