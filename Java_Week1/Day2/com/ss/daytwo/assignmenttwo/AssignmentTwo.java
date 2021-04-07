/**
 * 
 */
package com.ss.daytwo.assignmenttwo;

import java.util.Arrays;

/**
 * @author heman
 *
 */
public class AssignmentTwo {

	/**
	 * @param args
	 */
	
	// Finding a max value and the position of that value in a 2D array
	public static void main(String[] args) {
		
		// Creating a randomized 10x10 matrix
		int numRows = ((int) (Math.random()*10))+1;
		int numCols = ((int) (Math.random()*10))+1;
		
		int arr[][] = new int[numRows][numCols];
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				arr[i][j] = ((int) (Math.random()*100))+1;
			}
		}
		
		System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
		
		// Finding the max value and its position in the array
		int max = arr[0][0];
		int maxrow = 0;
		int maxcol = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
					maxrow = i;
					maxcol = j;
				}
			}
		}
		
		System.out.println("Max value is " + max + " at " + "arr["+maxrow+"]["+maxcol+"]");
	}

}
