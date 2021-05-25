package com.java.multithreading;

class Task4 implements Runnable {

	static Object lock = new Object();
	static int no;
	int reminder = 0;

	Task4(int reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {

		while (no < 10) {
			synchronized (lock) {
				while (no % 3 != reminder) {
					try {

						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " :: " + no);
				lock.notifyAll();
				no++;
			}

		}

	}

}

public class ThreadSequenceEx {
	
	public static void main(String[] args) {
		
	Thread t = new Thread(new Task4(0));
	Thread t1 = new Thread(new Task4(1));
	Thread t2 = new Thread(new Task4(2));
	
	t.start();
	t1.start();
	t2.start();
	
	}
}
