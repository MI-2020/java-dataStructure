package com.java.queue;

// front e1->e2->e3 rear
public class CustomArrayBasedCircularQueue<E> {

	E queue[];
	int capacity;
	int front,rear =-1;
	int size;
	
	@SuppressWarnings("unchecked")
	CustomArrayBasedCircularQueue(int capacity){
		this.capacity =capacity;	
		queue = (E[]) new Object[capacity];
	}
	
	
	public void enque(E data){
		
		if(capacity == size) {
			System.out.println("Overflow");	
			return;
		}
		
		if(front== -1 && rear == -1) {
			front =0;
			rear=0;
			queue[0]  = data;
			return;
		}else if(rear == capacity-1){
			rear = 0;
		}else {
			rear++;
		}
		
		queue[rear] = data;
		size++;	
		
	}
	
	public E deque(){

		if(size == 0) {
			System.out.println("Underflow");
			return null;
		}
		
		E remove = queue[front];
		
		if(front==capacity-1) {
			front = 0;
		}
		
		queue[front] = null;		
		front++;
		size--;
		
		return remove;
		
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for(E data : queue) {
			sb.append(data).append(":");
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		CustomArrayBasedCircularQueue<Integer> arrayCustQueue =new CustomArrayBasedCircularQueue<>(5);
		arrayCustQueue.enque(10);
		arrayCustQueue.enque(20);	
		arrayCustQueue.enque(30);	
		arrayCustQueue.enque(40);	
		arrayCustQueue.enque(50);	
			
		arrayCustQueue.deque();	
		arrayCustQueue.enque(40);
		System.out.println(arrayCustQueue);
	}
}
