package com.java.stack;

/**
 * front(L1)->L2->L3->L4->L3(rear)
 * 
 * @author Ashish
 *
 * @param <E>
 */
public class ArrayBasedCustomStack<E> {

	private int top; // for removal
	private int capacity;
	private E stack[];
	
	public ArrayBasedCustomStack(int capacity){
		this.capacity = capacity;
		top = -1;
		stack = (E[]) new Object[capacity];
	}

	public void push(E data) {
		
		if(capacity == top + 1) {
			System.out.println("Stack is full!");
			return;
		}
			top++;
			stack[top] = data;
	}

	public E pop() {
		if(top == -1) {
			System.out.println("Stack is Emply!");
			return null;
		}
			E data = stack[top];
			stack[top] = null;
			top--;
			return data;
	}
	
	public E peek() {
		
		if(top == -1) {
			System.out.println("Stack is Emply!");
			return null;
		}
			return stack[top];
	}

	public void traverse() {
		
		if(top == -1) return;
		
		for(int i = 0; i <= top; i++) {
			System.out.println(stack[i]);
		}
	}
	
	public boolean isEmpty() {		
		return top == -1 ? true:false;
	}
}
