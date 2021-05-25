package com.java.multithreading;

class Task5 implements Runnable{

	int remainder;
	static int number;
	static Object mutex =  new Object();
	Task5(int reminder){
		this.remainder = reminder;
	}
	
	@Override
	public void run() {
		
		while(number < 100) {
			
			synchronized (mutex) {
				
				while(number%2 != remainder) {
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" :: "+ number);
				number++;
				mutex.notify();
				
				
			}
			
		}

		
	}


}


public class EvenOddEx {
	
	public static void main(String[] args) {
		
	Thread t = new Thread(new Task5(0),"Even");
	Thread t1 = new Thread(new Task5(1),"ODD");
	
	t.start();
	t1.start();
	
	}
}
