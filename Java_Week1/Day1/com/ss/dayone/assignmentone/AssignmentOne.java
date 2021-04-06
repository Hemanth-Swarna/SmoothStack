/**
 * 
 */
package com.ss.dayone.assignmentone;

/**
 * @author heman
 *
 */
public class AssignmentOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("1)");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println(".........");

		System.out.println("2)");
		System.out.println("..........");
		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("3)");
		for (int i = 0; i < 4; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < (2 * i + 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("...........");

		System.out.println("4");
		System.out.println("............");
		for (int i = 3; i >= 0; i--) {
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < (2 * i + 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
