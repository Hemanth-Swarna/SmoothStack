/**
 * 
 */
package com.ss.daytwo.assignmentthree;

/**
 * @author heman
 *
 */
public class Triangle implements Shape {
	
	private int base;
	private int height;
	private double area;

	public Triangle(int base, int height) {
		super();
		this.base = base;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		area = 0.5 * base * height;
		return area;
	}

	@Override
	public void display() {
		System.out.println("The area is " + this.calculateArea());
	}

}
