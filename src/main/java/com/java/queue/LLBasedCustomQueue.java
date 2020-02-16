package com.java.queue;

/**
 * front(L1)->L2->L3->L4->L3(rear)
 * 
 * @author Ashish
 *
 * @param <E>
 */
public class LLBasedCustomQueue<E> {

	QNode<E> front; // for removal
	QNode<E> rear; // for addition

	static class QNode<E> {

		E data;
		QNode<E> next;

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

	public void deuqe() {

		if (front == null)
			return;

		QNode<E> tempNode = front;
		front = front.next;
		tempNode.next = null; // deference so that pick by GC
	}

	public void traverse() {

		if (front == null)
			return;

		while (front != null) {
			System.out.println(front.data);
			front = front.next;
		}
	}
}
