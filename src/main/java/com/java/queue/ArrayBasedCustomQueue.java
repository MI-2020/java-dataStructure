package com.java.queue;

/**
 * front(L1)->L2->L3->L4->L3(rear)
 * 
 * @author Ashish
 *
 * @param <E>
 */
public class ArrayBasedCustomQueue<E> {

	private int front; // for removal
	private int rear; // for addition
	private int capacity;
	E queue[];

	protected ArrayBasedCustomQueue(int capacity){
		front = rear = -1;
		queue = (E[]) new Object[capacity];
		this.capacity = capacity;
	}
	
	public void enquqe(E data) {
		
		if(capacity == rear + 1) {
			System.out.println("Queue is full!");
			return;
		}
			rear = rear+1;
			if(rear == 0) front = 0;
			queue[rear] = data;	
	}

	public E deuqe() {		
		if(rear == -1) {
			System.out.println("Queue is Empty!");
			return null;
		}
			E data = queue[0]; 
			for(int i=0;i <= rear ; i++) {
				queue[i] = queue[i+1];
			}
			rear--;
			return data;
	}

	public void traverse() {

		if (front == -1)
			return;

		for(int i=0; i <= rear; i++) {
			System.out.println(queue[i]);
		}
	}
	
	public boolean isEmpty() {
		return front == -1? true: false; 
	}
}
