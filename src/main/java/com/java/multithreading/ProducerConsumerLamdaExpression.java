package com.java.multithreading;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  Producer Consumer wait notify with lamda expression ( not separate class )
 */
public class ProducerConsumerLamdaExpression {

	public static void main(String[] args) throws InterruptedException {

		Queue<Integer> queue = new LinkedList<>();

		new Thread(() -> {
			synchronized (queue) {

				for (int i = 0; i < 20; i++) {
					if (queue.size() == 10) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					queue.add(i);
					System.out.println(Thread.currentThread().getName() + "::" + i);
					queue.notify();
				}
				queue.add(-1);

			}
		}).start();

		new Thread(() -> {
			boolean check = true;
			while (check) {

				synchronized (queue) {
					if (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						int data = queue.remove();
						System.out.println(Thread.currentThread().getName() + "::" + data);
						queue.notify();
						if (data == -1) {
							check = false;
						}

					}

				}
			}
		}).start();

	}
}
