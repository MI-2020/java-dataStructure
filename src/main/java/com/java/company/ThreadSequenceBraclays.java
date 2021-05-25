package com.java.company;

class Task101 implements Runnable {

	static int number = 0;
	static Object mutex = new Object();
	int remainder;
	static volatile boolean check = true;

	Task101(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {

		while (number < 10) {

			synchronized (mutex) {

				while (number % 3 != remainder) {

					try {
						mutex.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (remainder == 0) {
					System.out.println(Thread.currentThread().getName() + " :: " + remainder);
				} else {

					if (check) {
						System.out.println(Thread.currentThread().getName() + " :: " + remainder);
					}

					if (remainder == 1 && check) {
						check = false;
					} else if (remainder == 1 && !check) {
						check = true;
					}
				}

				number++;
				mutex.notifyAll();
			}

		}

	}

}

public class ThreadSequenceBraclays {

public static void main(String[] args) {
	
	Thread t1 = new Thread(new Task101(0));
	Thread t2 = new Thread(new Task101(1));
	Thread t3 = new Thread(new Task101(2));
	
	t1.start();
	t2.start();
	t3.start();
}
}
