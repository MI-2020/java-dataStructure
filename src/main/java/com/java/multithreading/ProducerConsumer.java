package com.java.multithreading;

import java.util.LinkedList;
import java.util.Queue;


/*
 *  Producer Consumer wait notify
 */
class Producer implements Runnable {

	Queue<Integer> queue = null;

	Producer(Queue<Integer> queue) {

		this.queue = queue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			synchronized (queue) {

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

		}
		queue.add(-1);

	}
}

class Consumer implements Runnable{
	
	volatile boolean check =true;
	Queue<Integer> queue = null;
	Consumer(Queue<Integer> queue ){
		this.queue =queue;
	}
	@Override
	public void run() {
		
		while(check) {
			
			synchronized (queue) {
				if(queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					int data = queue.remove();
					System.out.println(Thread.currentThread().getName()+"::"+data);
					queue.notify();
					if(data==-1) {
						check=false;
					}					
				}				
			}
		}
		
	}
}

public class ProducerConsumer {

	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>();
		Producer produce = new Producer(queue);
		Consumer consume =  new Consumer(queue);
		Thread t1 = new Thread(produce);
		Thread t2 = new Thread(consume);
		t1.start();
		t2.start();
	}
}
