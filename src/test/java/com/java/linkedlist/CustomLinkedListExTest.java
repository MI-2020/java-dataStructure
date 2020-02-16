package com.java.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomLinkedListExTest {

	private static CustomLinkedListEx custLLEx;
	private CustomLinkedList<Integer> linkedList1;
	private CustomLinkedList<Integer> linkedList2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		custLLEx = new CustomLinkedListEx();
	}

	@Before
	public void setUp() {
		linkedList1 = new CustomLinkedList<>();
		linkedList1.addNodeAtLast(1);
		linkedList1.addNodeAtLast(3);
		linkedList1.addNodeAtLast(5);

		linkedList2 = new CustomLinkedList<>();
		linkedList2.addNodeAtLast(2);
		linkedList2.addNodeAtLast(4);
		linkedList2.addNodeAtLast(6);
	}

	@Test
	public void testAddTwoNumbers() {
		CustomLinkedList<Integer> finalList = custLLEx.addTwoNumbers(linkedList1, linkedList2);

		Assert.assertEquals(3, finalList.head.data.intValue());
		finalList.deleteNode(3);
		Assert.assertEquals(8, finalList.head.data.intValue());
		finalList.deleteNode(8);
		Assert.assertEquals(1, finalList.head.data.intValue());
	}

	@Test
	public void testMergeTwoList() {
		CustomLinkedList<Integer> mergedList = custLLEx.mergeTwoList(linkedList1, linkedList2);

		Assert.assertEquals(1, mergedList.head.data.intValue());
		mergedList.deleteNode(1);
		Assert.assertEquals(2, mergedList.head.data.intValue());
		mergedList.deleteNode(2);
		Assert.assertEquals(3, mergedList.head.data.intValue());
		mergedList.deleteNode(3);
		Assert.assertEquals(4, mergedList.head.data.intValue());
		mergedList.deleteNode(4);
		Assert.assertEquals(5, mergedList.head.data.intValue());
		mergedList.deleteNode(5);
		Assert.assertEquals(6, mergedList.head.data.intValue());
	}

	@Test
	public void testReorderlist() {
		CustomLinkedList<Integer> mergedList = custLLEx.mergeTwoList(linkedList1, linkedList2);
		custLLEx.reorderlist(mergedList);

		Assert.assertEquals(1, mergedList.head.data.intValue());
		mergedList.deleteNode(1);
		Assert.assertEquals(6, mergedList.head.data.intValue());
		mergedList.deleteNode(6);
		Assert.assertEquals(2, mergedList.head.data.intValue());
		mergedList.deleteNode(2);
		Assert.assertEquals(5, mergedList.head.data.intValue());
		mergedList.deleteNode(5);
		Assert.assertEquals(3, mergedList.head.data.intValue());
		mergedList.deleteNode(3);
		Assert.assertEquals(4, mergedList.head.data.intValue());
	}

	@Test
	public void testSwapNodeInPair() {
		CustomLinkedList<Integer> mergedList = custLLEx.mergeTwoList(linkedList1, linkedList2);
		custLLEx.swapNodeInPair(mergedList);

		Assert.assertEquals(2, mergedList.head.data.intValue());
		mergedList.deleteNode(2);
		Assert.assertEquals(1, mergedList.head.data.intValue());
		mergedList.deleteNode(1);
		Assert.assertEquals(4, mergedList.head.data.intValue());
		mergedList.deleteNode(4);
		Assert.assertEquals(3, mergedList.head.data.intValue());
		mergedList.deleteNode(3);
		Assert.assertEquals(6, mergedList.head.data.intValue());
		mergedList.deleteNode(6);
		Assert.assertEquals(5, mergedList.head.data.intValue());	
	}

	@Test
	public void testOddEvenLinkedList() {
		CustomLinkedList<Integer> mergedList = custLLEx.mergeTwoList(linkedList1, linkedList2);
		custLLEx.OddEvenLinkedList(mergedList);

		Assert.assertEquals(1, mergedList.head.data.intValue());
		mergedList.deleteNode(1);
		Assert.assertEquals(3, mergedList.head.data.intValue());
		mergedList.deleteNode(3);
		Assert.assertEquals(5, mergedList.head.data.intValue());
		mergedList.deleteNode(5);
		Assert.assertEquals(2, mergedList.head.data.intValue());
		mergedList.deleteNode(2);
		Assert.assertEquals(4, mergedList.head.data.intValue());
		mergedList.deleteNode(4);
		Assert.assertEquals(6, mergedList.head.data.intValue());
	}

	@Test
	public void testIsPalindromList() {
		linkedList1.addNodeAtLast(5);
		linkedList1.addNodeAtLast(3);
		linkedList1.addNodeAtLast(1);
		Assert.assertEquals(true, custLLEx.isPalindromList(linkedList1));
	}

	@Test
	public void testRotateList() {
		custLLEx.rotateList(linkedList1, 2);
		
		Assert.assertEquals(3, linkedList1.head.data.intValue());
		linkedList1.deleteNode(3);
		Assert.assertEquals(5, linkedList1.head.data.intValue());
		linkedList1.deleteNode(5);
		Assert.assertEquals(1, linkedList1.head.data.intValue());
	}

	@Test
	public void testRemoveDuplicateNodeFromList() {
		linkedList1.addNodeAtLast(3);
		linkedList1.addNodeAtLast(5);
		custLLEx.removeDuplicateNodeFromList(linkedList1);
		
		Assert.assertEquals(1, linkedList1.head.data.intValue());
		linkedList1.deleteNode(1);
		Assert.assertEquals(3, linkedList1.head.data.intValue());
		linkedList1.deleteNode(3);
		Assert.assertEquals(5, linkedList1.head.data.intValue());
	}

	@Test
	public void testRemoveAllDuplicateNodeFromList() {
		/*linkedList1.addNodeAtLast(3);
		linkedList1.addNodeAtLast(5);
		custLLEx.removeAllDuplicateNodeFromList(linkedList1);
		
		Assert.assertEquals(1, linkedList1.head.data.intValue());*/		
	}

	@Test
	public void testReverseNodesKGroup() {
	}

	@Test
	public void testHasCycle() {
	}

	@Test
	public void testHasCycleAt() {
	}

}
