package com.java.multithreading;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Producer4 implements Runnable {

	Lock lock;
	Queue<Integer> queue;
	Condition full;
	Condition empty;

	Producer4(Queue<Integer> queue, Lock lock, Condition full, Condition empty) {
		this.queue = queue;
		this.lock = lock;
		this.full = full;
		this.empty = empty;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				lock.lock();

				if (queue.size() == 10) {
					try {
						full.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				System.out.println(Thread.currentThread().getName() + "::" + i);
				queue.add(i);
				Thread.sleep(1000);
				empty.signalAll();
			} catch (Exception e) {

			} finally {
				lock.unlock();
			}

		}
	}
}	

class Consumer4 implements Runnable {

	boolean check = true;
	Queue<Integer> queue;
	Lock lock;
	Condition full;
	Condition empty;

	Consumer4(Queue<Integer> queue, Lock lock, Condition full, Condition empty) {
		this.queue = queue;
		this.lock = lock;
		this.full = full;
		this.empty = empty;
	}

	@Override
	public void run() {

		while (true) {
			try {
				lock.lock();
				while (queue.size() == 0) {
					try {
						empty.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				int data = (int) queue.remove();
				System.out.println(Thread.currentThread().getName() + ":" + data);
				full.signalAll();
			} finally {
				lock.unlock();
			}
		}

	}

}

public class ProducerConsumerLockInterface {

	public static void main(String[] args) {

		Lock lock = new ReentrantLock();
		Condition full = lock.newCondition();
		Condition empty = lock.newCondition();

		Queue<Integer> queue = new LinkedBlockingQueue<>();

		Thread t1 = new Thread(new Producer4(queue, lock, full, empty));
		Thread t2 = new Thread(new Consumer4(queue, lock, full, empty));

		t1.start();
		t2.start();

	}
}
