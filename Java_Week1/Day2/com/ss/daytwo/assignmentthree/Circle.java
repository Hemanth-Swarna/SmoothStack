/**
 * 
 */
package com.ss.daytwo.assignmentthree;

/**
 * @author heman
 *
 */
public class Circle implements Shape {
	
	private int radius;
	private double area;

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		area = Math.PI*radius*radius;
		return area;

	}

	@Override
	public void display() {
		System.out.println("The area is " + this.calculateArea());
	}

}
