package com.java.stack;

/**
 * front(L1)->L2->L3->L4->L3(rear)
 * 
 * @author Ashish
 *
 * @param <E>
 */
public class ArrayBasedCustomStack<E> {

	private int top=-1; // for removal
	private int capacity;
	E stack[];
	
	@SuppressWarnings("unchecked")
	ArrayBasedCustomStack(int capacity){
		this.capacity =capacity;
		stack = (E[]) new Object[capacity];
	}

	public void push(E data) {
		
		if(capacity-1 == top) {
			System.out.println("Stack is full!");
		}else {
			top++;
			stack[top] = data;
			
		}
	}

	public E pop() {
		if(top == -1) {
			System.out.println("Stack is Emply!");
			return null;
		}
		else{
			E data = stack[top];
			stack[top] = null;
			top--;
			return data;
		}
	}
	
	public E peek() {
		if(top==-1) {
			System.out.println("Stack is Emply!");
			return null;
		}
		else{
			return stack[top];
		}
	}

	public void traverse() {
		
		if(top==0) return;
		
		for(int i =0; i <= top; i++) {
			System.out.println(stack[i]);
		}
	}
}
