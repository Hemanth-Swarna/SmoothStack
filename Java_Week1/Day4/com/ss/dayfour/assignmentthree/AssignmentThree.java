/**
 * 
 */
package com.ss.dayfour.assignmentthree;

/**
 * @author heman
 *
 */
public class AssignmentThree {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) {
		
		ProducerConsumer productionline = new ProducerConsumer();
		
		Thread produce = new Thread(new Runnable() {
			@Override
			public void run() {
				productionline.add();
			}
		});

		Thread consume = new Thread(new Runnable() {
			@Override
			public void run() {
				productionline.remove();
			}
		});
		System.out.println("Production is starting");
		produce.start();
		System.out.println("Consumption is starting");
		consume.start();
		
		
	}

}
