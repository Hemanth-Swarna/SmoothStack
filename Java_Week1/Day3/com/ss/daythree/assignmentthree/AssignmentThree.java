/**
 * 
 */
package com.ss.daythree.assignmentthree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author heman
 *
 */
public class AssignmentThree {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		char c = args[0].charAt(0);

		System.out.println(countCharInFile(c));

	}

	public static int countCharInFile(char c) throws IOException {
		InputStream is = null;
		int counter = 0;
		String statement = "";
		try {
			is = new FileInputStream("C:\\Users\\heman\\git\\SmoothStack\\Java_Week1\\Day3\\com\\ss\\daythree\\assignmentthree\\CharacterCounter");
			int data;
			while ((data = is.read()) != -1) {
				statement += (char)data;
			}
			
			for(int i = 0; i <statement.length(); i++) {
				if(c == statement.charAt(i)) {
					counter++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return counter;
	}

}
