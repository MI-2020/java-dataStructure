package com.java.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchEx1 {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newFixedThreadPool(3);

		CountDownLatch latch = new CountDownLatch(1);

		exec.submit(() -> {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Service1");
			latch.countDown();

		});

		exec.submit(() -> {
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Service2");
		});

		exec.submit(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Service3");
			latch.countDown();
		});

		exec.shutdown();

	}

}
