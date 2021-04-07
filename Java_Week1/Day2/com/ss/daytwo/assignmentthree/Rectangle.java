/**
 * 
 */
package com.ss.daytwo.assignmentthree;

/**
 * @author heman
 *
 */
public class Rectangle implements Shape {

	private int breadth;
	private int length;
	private double area;
	
	public Rectangle(int breadth, int length) {
		super();
		this.breadth = breadth;
		this.length = length;
	}

	@Override
	public double calculateArea() {
		area = breadth * length;
		return area;

	}

	@Override
	public void display() {
		System.out.println("The area is " + this.calculateArea());
	}

}
