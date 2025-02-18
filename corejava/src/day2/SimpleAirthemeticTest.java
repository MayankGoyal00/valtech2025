package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AirthmeticTest {

	private Airthmetic ari = new SimpleAirthemet();
	@Test
	void testadd() {
		assertEquals(5, ari.add(2.3, 2.7),0.0 );
	}
	@Test
	void testsub() {
		assertEquals(1, ari.sub(3, 2),0.0 );
	}
	@Test
	void testmul() {
		assertEquals(300, ari.mul(30,10),0.0 );
	}
	@Test
	void testdiv() {
		// 5./3 =1.66666666
		// expect 1.666666+-0.001
		assertEquals(1.666, ari.div(5., 3),0.001);
		assertEquals(Double.POSITIVE_INFINITY,ari.div(5.,0),0.0001);
	}
	
	void testdivZ() {
		assertEquals(2, ari.div(4, 2));
		assertEquals(2, ari.div(7, 2));
	}
	void testdivZero() {
		try {
		ari.div(3,0);
		fail("expected exception");
	}catch(Exception e) {
	}
}
}