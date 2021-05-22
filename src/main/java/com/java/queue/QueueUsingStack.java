package com.java.queue;

import java.util.Stack;


public class QueueUsingStack<E> {

	
	Stack<E> stack1 = new Stack<>(); 
	Stack<E> stack2 = new Stack<>();
	
	public void enqueue(E data) {
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());			
		}
		stack2.push(data);
		
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());			
		}
		
	}
	
	public E dequeue() {	
		
		return stack1.pop();
		
	}

	public static void main(String[] args) {
		
		QueueUsingStack<Integer> queue = new QueueUsingStack();
		queue.enqueue(40);
		queue.enqueue(20);
		queue.enqueue(50);
		
		System.out.println(queue.dequeue());
		queue.enqueue(10);
		System.out.println(queue.dequeue());
		
	}

}
