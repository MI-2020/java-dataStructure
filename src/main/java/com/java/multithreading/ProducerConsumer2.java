package com.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *  1 Producer  -> 10 Consumer are threads in Executors  {task create seperate}
 */

class Task implements Runnable {

	int no;

	Task(int no) {
		this.no = no;
	}

	@Override
	public void run() {
		System.out.println("print" + no);
	}

}

public class ProducerConsumer2 { 
	
	public static void main(String[] args) throws InterruptedException {

		ExecutorService exSer = Executors.newFixedThreadPool(10);
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {

				exSer.submit(new Task(i));
			}
			exSer.shutdown();

		}).start();

	}
}
