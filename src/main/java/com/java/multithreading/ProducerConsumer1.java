package com.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *  1 Producer  -> 10 Consumer are threads in Executors
 */
public class ProducerConsumer1 {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService exSer = Executors.newFixedThreadPool(10);
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {

				int no = i;
				exSer.submit(() -> System.out.println("print" + no));
			}
			exSer.shutdown();

		}).start();

	}
}
