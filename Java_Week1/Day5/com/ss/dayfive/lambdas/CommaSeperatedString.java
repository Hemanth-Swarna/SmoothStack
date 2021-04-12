package com.ss.dayfive.lambdas;

public class CommaSeperatedString {

	public static void main(String[] args) {
		int[] numbers = { 3, 5, 8, 12, 15 };

		System.out.println(stringify(numbers));
	}

	static String stringify(int[] numbers) {
		String cslist = "";
		for (int i = 0; i < numbers.length; i++) {
			if (i < numbers.length - 1) {
				cslist = cslist.concat(oddOrEven(numbers[i])) + ",";
			} else {
				cslist = cslist.concat(oddOrEven(numbers[i]));
			}
		}

		return cslist;
	}

	static String oddOrEven(int n) {
		if (n % 2 == 0) {
			return "e" + n;
		} else {
			return "o" + n;
		}
	}
}
