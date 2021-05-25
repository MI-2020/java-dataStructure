package com.java.multithreading;

/*
 *  Producer Consumer wait notify with custom queue
 */
class CustomQueue<E> {

	E[] queue;
	int front = -1, rear = -1;
	int size = 0;

	@SuppressWarnings("unchecked")
	public CustomQueue(int capacity) {
		queue = (E[]) new Object[capacity];
	}

	public void add(E data) {

		synchronized (queue) {
			if (size == queue.length) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (rear == -1) {
				front = 0;
				rear = 0;
			} else if (rear == queue.length - 1) {
				rear = 0;
			} else {
				rear++;
			}

			queue[rear] = data;
			size++;
			queue.notify();

		}
	}

	public Object remove() {

		Object data = null;
		synchronized (queue) {

			if (size == 0) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			data = queue[front];
			queue[front] = null;

			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == queue.length - 1) {
				front = 0;
			} else {
				front++;
			}

			size--;
			queue.notify();

		}
		return data;
	}

}

class Producer1 implements Runnable{
	
	CustomQueue<Integer> queue = null;
	Producer1(CustomQueue<Integer> queue ){
		
		this.queue =queue;
	}
	@Override
	public void run() {
				
			for(int i=1;i<20;i++) {
				System.out.println(Thread.currentThread().getName()+"::"+i);
				queue.add(i);
				
			}
			queue.add(-1);		
		
	}
}

class Consumer1 implements Runnable{
	
	volatile boolean check =true;
	CustomQueue<Integer> queue = null;
	Consumer1(CustomQueue<Integer> queue ){
		this.queue =queue;
	}
	@Override
	public void run() {
		
		while(check) {
							
					Integer data = (Integer)queue.remove();
					System.out.println(Thread.currentThread().getName()+":"+data);
					if(data==-1) {
						check=false;
					}
		}
		
	}
}

public class ProducerConsumerWithCustomQueue {

	public static void main(String[] args) {

		CustomQueue<Integer> queue = new CustomQueue<>(10);
		Producer1 produce = new Producer1(queue);
		Consumer1 consume = new Consumer1(queue);
		Thread t1 = new Thread(produce);
		Thread t2 = new Thread(consume);
		t1.start();
		t2.start();
	}
}
