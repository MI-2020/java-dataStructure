package com.java.stack;

import com.java.queue.LLBasedCustomQueue;

public class StackUsingQueue<E> extends LLBasedCustomQueue<E>{

	
	//private E top;
	
	LLBasedCustomQueue<E> queue1 = new LLBasedCustomQueue<>();
	LLBasedCustomQueue<E> queue2 = new LLBasedCustomQueue<>();
	

	public void push(E data) {
		queue2.enquqe(data);
		
		while(queue1.isEmpty()) {	
			queue2.enquqe(queue1.deuqe());
		}
		LLBasedCustomQueue<E> temp = queue2;
		queue2 = queue1;
		queue1 = temp;		
	}

	public void pop() {
		queue1.deuqe();		
	}
	
	public E peek() {
		
		return queue1.first();
	}
}
