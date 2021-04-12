/**
 * 
 */
package com.ss.weeklyassignment.recursion;

/**
 * @author heman
 *
 */
public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(groupSumClump(0, new int[] { 2, 4, 8 }, 10));
		System.out.println(groupSumClump(0, new int[] { 1, 2, 4, 8, 1 }, 14));
		System.out.println(groupSumClump(0, new int[] { 2, 4, 4, 8 }, 14));

	}

	public static boolean groupSumClump(int start, int[] nums, int target) {

		// Base Case
		if (start >= nums.length)
			return target == 0;

		// We take the sum of the first value as well as start counting the number of numbers used
		int sum = nums[start];
		int count = 1;
		
		// We add all like numbers
		for (int i = start + 1; i < nums.length; i++) {
			if (nums[i] == nums[start]) {
				sum += nums[i];
				count++;
			}
		}
		
		// Now we change our starting position to go to another number and see if we can reach our target
		return groupSumClump(start + count, nums, target - sum) || groupSumClump(start + count, nums, target);

	}

}
