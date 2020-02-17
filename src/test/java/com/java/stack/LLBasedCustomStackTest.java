package com.java.stack;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LLBasedCustomStackTest {

	LLBasedCustomStack<Integer> llCustStack;

	@Before
	public void setUp() throws Exception {
		
		llCustStack =new LLBasedCustomStack<>();
		llCustStack.push(10);
		llCustStack.push(20);
	}

	@Test
	public void testPush() {
		llCustStack.push(30);
		Assert.assertEquals(30, llCustStack.peek().intValue());
	}

	@Test
	public void testPop() {
		Assert.assertEquals(20, llCustStack.peek().intValue());
	}

	@Test
	public void testPeek() {
		Assert.assertEquals(20, llCustStack.peek().intValue());
	}
	
	@Test
	public void testIsEmpty() {
		Assert.assertFalse(llCustStack.isEmpty());
	}
	

}
