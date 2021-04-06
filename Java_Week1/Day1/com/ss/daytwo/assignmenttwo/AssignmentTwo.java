/**
 * 
 */
package com.ss.daytwo.assignmenttwo;

import java.util.Scanner;

/**
 * @author heman
 *
 */
public class AssignmentTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int num = (int) (Math.random() * 101);

		Scanner sc = new Scanner(System.in);
		int guesses = 5;
		int guess;

		System.out.println("Hi, please enter a number:");
		while (0 < guesses && sc.hasNextInt()) {
			guess = sc.nextInt();
			int diff = Math.abs(num - guess);
			if (diff >= 0 && diff <= 10) {
				if (diff == 0) {
					System.out.println("Congrats, you got the exact value: " + num);
					sc.close();
					System.exit(0);
				} else {
					System.out.println("You were very close. The number was " + num + " and you were only off by " + diff);
					sc.close();
					System.exit(0);
				}
			} else {
				guesses--;
				System.out.println("Please guess again:");
			}
			
		}
		
		if(guesses == 0) {
			System.out.println("Unfortunately you have used all your opportunities. The number was " + num);
		}

	}

}
