/**
 * 
 */
package com.ss.weeklyassignment.lambdas;

import java.util.Scanner;

/**
 * @author heman
 *
 */
public class AssignmentOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTests = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numOfTests; i++) {
			String[] vals = sc.nextLine().split(" ");
			switchCondition(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]));
		}
		sc.close();
	}

	static PerformOperation isOdd = n -> {
		if(n < 0) {
			n = Math.abs(n);
		}
		if (n % 2 == 1) {
			System.out.println("ODD");
			return true;
		} else {
			System.out.println("EVEN");
			return false;
		}
	};

	static PerformOperation isPrime = n -> {

		if (n <= 1) {
			System.out.println("COMPOSITE");
			return false;
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				System.out.println("COMPOSITE");
				return false;
			}
		}

		System.out.println("PRIME");
		return true;

	};

	static PerformOperation isPalindrome = n -> {
		if (n < 0) {
			System.out.println("NOT PALINDROME");
			return false;
		}
		Integer temp = n;
		String s1 = temp.toString();
		String s2 = "";
		for (int i = s1.length() - 1; i >= 0; i--) {
			s2 = s2.concat(s1.charAt(i) + "");
		}
		int temp2 = Integer.parseInt(s2);
		if (temp2 == n) {
			System.out.println("PALINDROME");
			return true;
		} else {
			System.out.println("NOT PALINDROME");
			return false;
		}
	};

	static boolean switchCondition(int type, int num) {
		switch (type) {
		case 1:
			return isOdd.input(num);
		case 2:
			return isPrime.input(num);
		case 3:
			return isPalindrome.input(num);
		default:
			System.err.println("Only values [1,2,3] are acceptable entries");
			throw new IllegalArgumentException();
		}
	}
}
