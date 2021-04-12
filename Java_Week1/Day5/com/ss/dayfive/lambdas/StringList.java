/**
 * 
 */
package com.ss.dayfive.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heman
 *
 */
public class StringList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> words = Arrays.asList("age", "argos", "amsterdam", "bar", "and", "band");
		System.out.println(stringArrayFilter(words));

	}

	public static List<String> stringArrayFilter(List<String> words) {
		words = words.stream().filter(s -> s.length() == 3 && s.charAt(0) == 'a').collect(Collectors.toList());
		return words;
	}

}
