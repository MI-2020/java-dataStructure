package com.java.linkedlist;

import com.java.linkedlist.CustomLinkedList.Node;

public class CustomLinkedListEx {

	public static void main(String[] args) {

		CustomLinkedListEx Obj = new CustomLinkedListEx();

		CustomLinkedList<Integer> list = new CustomLinkedList<>();
		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(30);
		Node<Integer> node4 = new Node<>(40);

		list.head = node1;
		list.head.next = node2;
		list.head.next.next = node3;
		list.head.next.next.next = node4;
		list.head.next.next.next.next = node2;

		Obj.hasCycleAt(list);
	}

	/**
	 * Input: 1->2->9 + 3->2 Output 1->6->1
	 * 
	 * @param list
	 */
	public CustomLinkedList<Integer> addTwoNumbers(CustomLinkedList<Integer> linkedList1,
			CustomLinkedList<Integer> linkedList2) {

		CustomLinkedList<Integer> finalLL = new CustomLinkedList<>();
		linkedList1.reverseLinkedList();
		linkedList2.reverseLinkedList();

		Node<Integer> ptr1 = linkedList1.head;
		Node<Integer> ptr2 = linkedList2.head;

		int remainder, quotient = 0;
		while (ptr1 != null || ptr2 != null) {

			int data = quotient + (ptr1 != null ? ptr1.data : 0) + (ptr2 != null ? ptr2.data : 0);
			quotient = data / 10;
			remainder = data % 10;

			finalLL.addNodeAtLast(remainder);
			ptr1 = ptr1 != null ? ptr1.next : ptr1;
			ptr2 = ptr2 != null ? ptr2.next : ptr2;
		}

		if (quotient > 0)
			finalLL.addNodeAtLast(quotient);

		System.out.println("Final Result:");
		finalLL.reverseLinkedList();
		finalLL.traverse();

		return finalLL;
	}

	public CustomLinkedList<Integer> mergeTwoList(CustomLinkedList<Integer> linkedList,
			CustomLinkedList<Integer> linkedList1) {
		CustomLinkedList<Integer> finalList = new CustomLinkedList<>();

		Node<Integer> ptr1 = linkedList.head;
		Node<Integer> ptr2 = linkedList1.head;

		while (ptr1 != null && ptr2 != null) {
			if (ptr1.data < ptr2.data) {
				finalList.addNodeAtLast(ptr1.data);
				ptr1 = ptr1.next;
			} else if (ptr1.data == ptr2.data) {
				finalList.addNodeAtLast(ptr1.data);
				finalList.addNodeAtLast(ptr2.data);
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			} else {
				finalList.addNodeAtLast(ptr2.data);
				ptr2 = ptr2.next;
			}
		}

		while (ptr1 != null) {
			finalList.addNodeAtLast(ptr1.data);
			ptr1 = ptr1.next;
		}
		while (ptr2 != null) {
			finalList.addNodeAtLast(ptr2.data);
			ptr2 = ptr2.next;
		}
		finalList.traverse();
		return finalList;
	}

	/**
	 * Input: L0->L1->L2->L3->L4->L5 Output L0->L5->L1->L4->L2->L3
	 * 
	 * @param list
	 */
	public void reorderlist(CustomLinkedList<Integer> list) {

		Node<Integer> mid = list.head;
		Node<Integer> tail = list.head;

		while (tail != null && tail.next != null) {
			mid = mid.next;
			tail = tail.next.next;
		}
		Node<Integer> focusNode = mid;

		Node<Integer> prev = null;
		Node<Integer> next = null;

		while (focusNode != null) {

			next = focusNode.next;
			focusNode.next = prev;
			prev = focusNode;
			focusNode = next;
		}

		mid = prev;

		Node<Integer> left = list.head;
		Node<Integer> midNext = null;
		while (mid != null) {

			midNext = mid.next;
			mid.next = left.next;
			left.next = mid;
			left = mid.next;
			mid = midNext;
		}

		left.next = null;
		list.traverse();
	}

	/**
	 * Input: L1->L2->L3->L4->L5 Output L2->L1->L4->L3->L5
	 * 
	 * @param list
	 */
	public void swapNodeInPair(CustomLinkedList<Integer> list) {

		Node<Integer> ptr1 = null, ptr2 = null;
		if (list.head == null && list.head.next == null) {
			return;
		}

		ptr1 = list.head; // previous Pointer
		ptr2 = list.head.next; // thats the main pointer on which iteration happen
		list.head = list.head.next; // head to move as Head would be 2nd node

		Node<Integer> ptr2Next = null; // next pointer
		while (ptr2 != null) {

			ptr2Next = ptr2.next;
			ptr2.next = ptr1;

			if (ptr2Next == null || ptr2Next.next == null) {
				ptr1.next = ptr2Next;
				break;
			}
			ptr1.next = ptr2Next.next;

			ptr2 = ptr2Next.next;
			ptr1 = ptr2Next;

		}
		list.traverse();
	}

	/**
	 * Input: L1->L2->L3->L4->L5 Output L1->L3->L5->L2->L4
	 * 
	 * @param list
	 */
	public void OddEvenLinkedList(CustomLinkedList<Integer> list) {

		if (list.head == null || list.head.next == null) {
			return;
		}

		Node<Integer> evenHead = list.head.next;
		Node<Integer> ptr1 = list.head;
		Node<Integer> ptr2 = list.head.next;
		while (ptr2 != null && ptr2.next != null) {

			ptr1.next = ptr1.next.next;
			ptr2.next = ptr2.next.next;

			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		ptr1.next = evenHead;

	}

	/**
	 * Input: L1->L2->L3->L2->L1 Output true
	 * 
	 * @param list
	 */
	public boolean isPalindromList(CustomLinkedList<Integer> list) {

		Node<Integer> start = list.head;
		Node<Integer> ptr1 = list.head;
		Node<Integer> ptr2 = list.head;

		while (ptr2 != null && ptr2.next != null) {

			ptr2 = ptr2.next.next;
			ptr1 = ptr1.next;
		}

		Node<Integer> mid = (ptr2 != null) ? ptr1.next : ptr1;
		Node<Integer> prev = null, next = null;

		while (mid != null) {

			next = mid.next;
			mid.next = prev;
			prev = mid;
			mid = next;
		}

		while (prev != null) {

			if (start.data == prev.data) {
				prev = prev.next;
				start = start.next;
			} else {
				System.out.println("Not Palaindrom");
				return false;
			}
		}

		System.out.println("Palindrom");
		return true;

	}

	/**
	 * Input: L1->L2->L3->L4->L5 & k=2 Output L4->L5->L1->L2->L3
	 * 
	 * @param list
	 */
	public void rotateList(CustomLinkedList<Integer> list, int k) {

		Node<Integer> ptr1 = list.head;
		Node<Integer> ptr2 = list.head;
		Node<Integer> start = list.head;

		while (k >= 1) {
			ptr2 = ptr2.next;
			k--;
		}

		while (ptr2.next != null) {
			ptr2 = ptr2.next;
			ptr1 = ptr1.next;
		}

		Node<Integer> extra = ptr1.next;
		ptr1.next = null;

		list.head = extra;
		while (extra.next != null) {
			extra = extra.next;
		}

		extra.next = start;

	}

	public void removeDuplicateNodeFromList(CustomLinkedList<Integer> list) {

		Node<Integer> focusNode = list.head;
		Node<Integer> prev = null, next = null;

		while (focusNode != null) {

			next = focusNode.next;
			if (prev != null && prev.data == focusNode.data) {
				prev.next = next;
			} else {
				prev = focusNode;
			}

			focusNode = next;
		}
	}

	/**
	 * Input: L1->L2->L2->L3->L4->L4-L5 Output L1->L3-L5
	 * 
	 * @param list
	 */
	public void removeAllDuplicateNodeFromList(CustomLinkedList<Integer> list) {

		Node<Integer> focusNode = list.head;
		Node<Integer> prev = null, next = null;

		while (focusNode != null) {

			next = focusNode.next;
			if (prev != null && prev.data == focusNode.data) {
				prev.next = next;
			} else {
				prev = focusNode;
			}

			focusNode = next;
		}
	}

	/**
	 * Input: L1->L2->L3->L4-L5 Output L3->L2-L1->L4-L5
	 * 
	 * @param list
	 */
	public void reverseNodesKGroup(CustomLinkedList<Integer> list, int k) {

		Node<Integer> ptr1 = list.head;
		Node<Integer> ptr2 = list.head;
		Node<Integer> endPtr = null;
		int pointShift = k;
		boolean check = true;

		while (pointShift >= 1 && ptr2 != null) {
			Node<Integer> prev = null, next = null;
			ptr2 = ptr2.next;
			pointShift--;

			if (ptr2 != null && pointShift == 1 && check) {
				list.head = ptr2;
				check = false;
			}
			if (pointShift == 0) {
				Node<Integer> startPtr = ptr1;
				while (ptr1 != ptr2) {
					next = ptr1.next;
					ptr1.next = prev;
					prev = ptr1;
					ptr1 = next;
				}
				if (endPtr == null) {
					endPtr = startPtr;
				} else {
					endPtr.next = prev;
					while (endPtr.next != null)
						endPtr = endPtr.next;
				}
				endPtr.next = next;
				pointShift = k;
			}
		}
	}

	/**
	 * Input: L1->L2->L3->L1-L5 Output true
	 * 
	 * @param list
	 */
	public void hasCycle(CustomLinkedList<Integer> list) {

		if (list.head == null || list.head.next == null) {
			return;
		}

		Node<Integer> ptr1 = list.head;
		Node<Integer> ptr2 = list.head.next;

		while (ptr1 != ptr2) {

			if (ptr2 == null || ptr2.next == null) {
				System.out.println("No Cycle");
				return;
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		System.out.println("YES has Cycle:");
	}

	public void hasCycleAt(CustomLinkedList<Integer> list) {

		Node<Integer> intersect = hasCycle1(list);

		if (intersect == null) {
			return;
		} else {

			Node<Integer> ptr1 = intersect;
			Node<Integer> ptr2 = list.head;

			while (ptr1 != ptr2) {
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
			System.out.println("Meet at:" + ptr1.data);
		}

	}

	private Node<Integer> hasCycle1(CustomLinkedList<Integer> list) {

		if (list.head == null || list.head.next == null) {
			return null;
		}

		Node<Integer> ptr1 = list.head;
		Node<Integer> ptr2 = list.head;

		while (ptr2 != null && ptr2.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			if (ptr1 == ptr2) {
				return ptr1;
			}
		}
		return null;
	}

}
