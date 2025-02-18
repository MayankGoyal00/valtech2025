package com.valtech.training.simple.interest;

import junit.framework.TestCase;

public class SimpleInterestTest extends TestCase {
	
	public void test() {
		assertEquals(500,SimpleInterest.compute(500,10,10));
		
	}

}
