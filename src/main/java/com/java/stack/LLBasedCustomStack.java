package com.java.stack;

/**
 * front(L1)->L2->L3->L4->L3(rear)
 * 
 * @author Ashish
 *
 * @param <E>
 */
public class LLBasedCustomStack<E> {

	private SNode<E> top; 
	
	  private static class SNode<E> {

		private E data;
		SNode<E> next;

		SNode(E data) {
			this.data = data;
		}
	}

	public void push(E data) {

		SNode<E> newNode = new SNode<>(data);
		if (top == null) {
			top = newNode;
			return;
		}
		newNode.next = top;
		top = newNode;
	}

	public E pop() {
		
		if (top == null) return null;
		
		SNode<E> tempNode = top; 
		top = top.next;
		tempNode.next =null;	// for deallocate memory
		
		return tempNode.data;
	}
	
	public E peek() {
		
		if (top == null) return null;
		return top.data;
	}

	public void traverse() {

		if (top == null)
			return;

		while (top != null) {
			System.out.println(top.data);
			top = top.next;
		}
	}
	
	public boolean isEmpty() {
		return top == null ? true:false;
	}
}
