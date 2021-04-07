/**
 * 
 */
package com.ss.daytwo.assignmentthree;

/**
 * @author heman
 *
 */
public class AssignmentThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape circle = new Circle(5);
		Shape triangle = new Triangle(3, 4);
		Shape rectangle = new Rectangle(6,7);
		
		// Not explicitly calling calculateArea() because we call it in display()
		circle.display();
		triangle.display();
		rectangle.display();

	}

}
