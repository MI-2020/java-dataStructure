package com.java.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayBasedCustomQueueTest {

	ArrayBasedCustomQueue<Integer> arrayCustQueue;

	@Before
	public void setUp() throws Exception {
		arrayCustQueue =new ArrayBasedCustomQueue<>(10);
		arrayCustQueue.enquqe(10);
		arrayCustQueue.enquqe(20);		
	}

	@Test
	public void testEnquqe() {
		arrayCustQueue.enquqe(30);
	}

	@Test
	public void testDeuqe() {
		Assert.assertEquals(10, arrayCustQueue.deuqe().intValue());
		Assert.assertEquals(20, arrayCustQueue.deuqe().intValue());
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(arrayCustQueue.isEmpty());
	}

}
