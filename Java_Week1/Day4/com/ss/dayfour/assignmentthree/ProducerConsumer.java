package com.ss.dayfour.assignmentthree;

import java.util.LinkedList;

public class ProducerConsumer {

	LinkedList<Integer> queue = new LinkedList<Integer>();
	int size = 7;

	public void add() {
		while (true) {
			synchronized (this) {
				while (queue.size() == size) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int item = (int) Math.random() * 100;
				System.out.println("Item was added");
				queue.add(item);
				notify();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void remove() {
		while (true) {
			synchronized (this) {
				while (queue.size() == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				queue.removeFirst();
				System.out.println("Item was removed");
				notify();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
