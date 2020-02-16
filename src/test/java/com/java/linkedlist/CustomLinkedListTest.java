package com.java.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.java.linkedlist.CustomLinkedList.Node;

public class CustomLinkedListTest {

	private CustomLinkedList<Integer> linkedList;

	@Before
	public void setUp() throws Exception {
		linkedList = new CustomLinkedList<>();
		linkedList.addNodeAtLast(10);
		linkedList.addNodeAtLast(20);
		linkedList.addNodeAtLast(30);
	}

	@Test
	public void testAddNodeAtLast() {
		linkedList.addNodeAtLast(40);
		Node<Integer> node = linkedList.head;
		while (node.next != null)
			node = node.next;

		Assert.assertEquals(40, node.data.intValue());
	}

	@Test
	public void testAddNodeAtAfterGivenNode() {
		linkedList.addNodeAtAfterGivenNode(30, 40);
		Node<Integer> node = linkedList.head;
		while (node.next != null)
			node = node.next;

		Assert.assertEquals(40, node.data.intValue());
	}

	@Test
	public void testAddNodeAtFirst() {
		linkedList.addNodeAtFirst(40);
		Assert.assertEquals(40, linkedList.head.data.intValue());
	}

	@Test
	public void testDeleteNode() {
		linkedList.deleteNode(30);
		Assert.assertNotEquals(30, linkedList.head.data.intValue());
	}

	@Test
	public void testSearchData() {
		Assert.assertEquals(true, linkedList.searchData(20));
	}

	@Test
	public void testReverseLinkedList() {
		linkedList.reverseLinkedList();
		Assert.assertEquals(30, linkedList.head.data.intValue());
		linkedList.deleteNode(30);
		Assert.assertEquals(20, linkedList.head.data.intValue());
		linkedList.deleteNode(20);
		Assert.assertEquals(10, linkedList.head.data.intValue());
	}

	@Test
	public void testFindMiddleNode() {
		Assert.assertEquals(20, linkedList.findMiddleNode().intValue());
	}

	@Test
	public void testNthNodeFromLast() {
		Assert.assertEquals(20, linkedList.NthNodeFromLast(2).intValue());
	}

	@Test
	public void testSizeOfLinkedListRecursive() {
		Assert.assertEquals(3, linkedList.sizeOfLinkedListRecursive(linkedList.head));
	}

	@Test
	public void testRemoveNthNodeFromLast() {
		Assert.assertEquals(true, linkedList.removeNthNodeFromLast(2));
	}

}
