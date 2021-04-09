/**
 * 
 */
package com.ss.dayfour.assignmenttwo;

/**
 * @author heman
 *
 */
public class AssignmentTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s1 = new String("Hi");
		String s2 = new String("Bye");
		
		Runnable t1 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (s1) {
						Thread.sleep(100);
						synchronized (s2) {
							System.out.println("Thread 1 has accquired locks");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Runnable t2 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (s1) {
						Thread.sleep(100);
						synchronized (s2) {
							System.out.println("Thread 2 has accquired locks");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(t1).start();
		new Thread(t2).start();
		System.out.println(s1 + " " + s2);

	}

}
