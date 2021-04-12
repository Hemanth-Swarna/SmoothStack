/**
 * 
 */
package com.ss.dayfive.lambdas;

import java.util.Arrays;

/**
 * @author heman
 *
 */
public class BasicLambdas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] strings = { "basketball", "football", "baseball", "tennis", "golf", "soccer" };
		
		Arrays.sort(strings, (s1,s2) -> (s1.length() - s2.length()));
		for (String s : strings) {
			System.out.println(s);
		}
		
		Arrays.sort(strings, (s1,s2) -> (s2.length() - s1.length()));
		for (String s : strings) {
			System.out.println(s);
		}
		
		Arrays.sort(strings, (s1,s2) -> (s1.charAt(0) - s2.charAt(0)));
		for (String s : strings) {
			System.out.println(s);
		}
		
		Arrays.sort(strings, (s1,s2) -> Integer.compare(s1.contains("e") ? 0:1, s2.contains("e") ? 0:1));
		for (String s : strings) {
			System.out.println(s);
		}
		
		Arrays.sort(strings, (s1,s2) -> compares(s1,s2));
		for (String s : strings) {
			System.out.println(s);
		}
	}
	
	public static int compares(String s1, String s2) {
		int num = Integer.compare(s1.contains("e") ? 0:1, s2.contains("e") ? 0:1);
		return num;
	}

}
