/**
 * 
 */
package com.ss.daythree.assignmenttwo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author heman
 *
 */
public class AssignmentTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		appendToFile("I was born in May");
	}
	
	public static void appendToFile(String data) {
		try {
			Files.write(Paths.get("C:\\Users\\heman\\git\\SmoothStack\\Java_Week1\\Day3\\com\\ss\\daythree\\assignmenttwo\\AppendingText"), data.getBytes(), StandardOpenOption.APPEND);
		}catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
