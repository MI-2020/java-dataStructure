package com.java.queue;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LLBasedCustomQueueTest {
	
	LLBasedCustomQueue<Integer> llCustQueue;

	@Before
	public void setUp() throws Exception {
		llCustQueue =new LLBasedCustomQueue<>();
		llCustQueue.enquqe(10);
		llCustQueue.enquqe(20);
		
	}

	@Test
	public void testEnquqe() {
		llCustQueue.enquqe(30);
		Assert.assertEquals(10, llCustQueue.deuqe().intValue());
	}

	@Test
	public void testDeuqe() {
		Assert.assertEquals(10,llCustQueue.deuqe().intValue());
		Assert.assertEquals(20,llCustQueue.deuqe().intValue());
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(llCustQueue.isEmpty());
	}

}
