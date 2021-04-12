/**
 * 
 */
package com.ss.weeklyassignment.functionals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heman
 *
 */
public class Functionals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] integers = { 41, 22, 56, 0};
		Integer[] rint = rightmost.function(integers);
		for (int i : rint) {
			System.out.println(i);
		}
		Integer[] dint = doubled.function(integers);
		for (int i : dint) {
			System.out.println(i);
		}
		String[] strings = { "Excellent", "day", "at", "New", "Mexico" };
		String[] stringswithoutX = removeX.function(strings);
		for (String s : stringswithoutX) {
			System.out.println(s);
		}

	}

	static Functional<Integer> rightmost = n -> {
		for (int i : n) {
			if (i < 0) {
				System.err.println("All integers should be non-negative");
				return null;
			}
		}

		List<Integer> arrlist = new ArrayList<>();
		for (int i : n) {
			arrlist.add(i);
		}

		List<Integer> newarrlist = new ArrayList<>();
		for (int i = 0; i < arrlist.size(); i++) {
			int value = arrlist.get(i) % 10;
			newarrlist.add(value);
		}

		return newarrlist.toArray(new Integer[newarrlist.size()]);

	};

	static Functional<Integer> doubled = n -> {

		List<Integer> arrlist = new ArrayList<>();
		for (int i : n) {
			arrlist.add(i);
		}

		List<Integer> newarrlist = new ArrayList<>();
		for (int i = 0; i < arrlist.size(); i++) {
			int value = arrlist.get(i) * 2;
			newarrlist.add(value);
		}

		return newarrlist.toArray(new Integer[newarrlist.size()]);

	};
	
	static Functional<String> removeX = n -> {

		List<String> arrlist = new ArrayList<>();
		for (String s : n) {
			arrlist.add(s);
		}

		List<String> newarrlist = new ArrayList<>();
		for (int i = 0; i < arrlist.size(); i++) {
			String value = arrlist.get(i).replaceAll("x", "");
			newarrlist.add(value);
		}

		return newarrlist.toArray(new String[newarrlist.size()]);

	};
	
}
