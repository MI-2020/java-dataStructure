package com.java.queue;

/**
 * front(L1)->L2->L3->L4->L3(rear)
 * 
 * @author Ashish
 *
 * @param <E>
 */
public class LLBasedCustomQueue<E> {

	private QNode<E> front; // for removal
	private QNode<E> rear; // for addition

	public static class QNode<E> {

		private E data;
		private QNode<E> next;

		QNode(E data) {
			this.data = data;
		}
	}

	public void enquqe(E data) {

		QNode<E> newNode = new QNode<>(data);
		if (rear == null) {
			front = rear = newNode;
			return;
		}
		rear.next = newNode;
		rear = newNode;
	}

	public E deuqe() {

		if (front == null)
			return null;

		QNode<E> tempNode = front;
		if(front.next == null) {
			front = rear = null;
		}else {
			front = front.next;
		}
		tempNode.next = null; // dereference so that pick by GC
		return tempNode.data;
	}

	public void traverse() {

		if (front == null)
			return;

		while (front != null) {
			System.out.println(front.data);
			front = front.next;
		}
	}
	
	public boolean isEmpty() {
		return front == null? true: false; 
	}
	
	public E first() {
		return front == null? null: front.data; 
	}
}
