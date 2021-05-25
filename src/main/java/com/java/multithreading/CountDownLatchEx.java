package com.java.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Service1 {
	CountDownLatch latch = null;
	Service1(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void m1(){
		System.out.println("M1");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();
		
	}
	
}

class Service2 {
	CountDownLatch latch = null;
	Service2(CountDownLatch latch){
		this.latch=  latch;
	}
	
	public void m2(){
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("M2");
	}
	
}

public class CountDownLatchEx {

	public static void main(String[] args) {
		ExecutorService excService = Executors.newFixedThreadPool(2);

		CountDownLatch latch = new CountDownLatch(1);
		Service1 service1 = new Service1(latch);
		Service2 service2 = new Service2(latch);

		excService.submit(() -> service2.m2());
		excService.submit(() -> service1.m1());

		excService.shutdown();
		/*
		 * Thread t = new Thread(()-> service1.m1()); t.start();
		 * 
		 * 
		 * Service2 service2 = new Service2(latch);
		 * 
		 * Thread t1 = new Thread(()-> service2.m2()); t1.start();
		 */

	}
}
