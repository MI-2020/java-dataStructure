package com.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task6 {

	public synchronized void m1() {
		try {
			System.out.println("I m in m1");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void m2() {
		System.out.println("I m in m2");
	}
}

public class SynchronizedMethodEx {

	public static void main(String[] args) {

		Task6 task = new Task6();
		ExecutorService ex = Executors.newFixedThreadPool(2);
		ex.submit(() -> task.m1());
		ex.submit(() -> task.m2());

		ex.shutdown();

		System.out.println("Main End!");
	}

}
