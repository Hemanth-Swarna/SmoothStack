/**
 * 
 */
package com.ss.daythree.assignmentone;

import java.io.File;
import java.io.FileNotFoundException;
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

//	    File file = new File("C:\\Users\\heman\\OneDrive\\Documents");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the File path: ");
		String filePath = null;
		try {
			filePath = sc.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] fileList = null;
			File file = new File(filePath);
			fileList = file.list();

		for (String str : fileList) {
			System.out.println(str);
		}
	}
}
