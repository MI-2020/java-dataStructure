package com.java.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayBasedCustomStackTest {
	
	private ArrayBasedCustomStack<Integer> arrayCustStack;

	@Before
	public void setUp() throws Exception {
		
		arrayCustStack =new ArrayBasedCustomStack<>(10);
		arrayCustStack.push(10);
		arrayCustStack.push(20);
	}

	@Test
	public void testPush() {
		arrayCustStack.push(30);
		Assert.assertEquals(30, arrayCustStack.peek().intValue());
	}

	@Test
	public void testPop() {
		Assert.assertEquals(20, arrayCustStack.peek().intValue());
	}

	@Test
	public void testPeek() {
		Assert.assertEquals(20, arrayCustStack.peek().intValue());
	}

}
