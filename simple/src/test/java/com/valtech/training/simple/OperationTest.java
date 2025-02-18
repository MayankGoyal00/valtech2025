package com.valtech.training.simple;

import junit.framework.TestCase;

public class OperationTest extends TestCase {
	
	
//	Operation add=(a,b)->a+b;
//	Operation sub=(a,b)->a-b;
//	Operation multi=(a,b)->a*b;
//	Operation div=(a,b)->a/b;
	
	public void testAdd() {
		assertEquals(5,Operation.ADD.perform(2,3));
	}
	public void testSub() {
		assertEquals(5,Operation.SUB.perform(11,6));
	}
	public void testMulti() {
		assertEquals(6,Operation.MULTI.perform(2, 3));
	}
	public void testDiv() {
		assertEquals(3,Operation.DIV.perform(6, 2));
	}
}
