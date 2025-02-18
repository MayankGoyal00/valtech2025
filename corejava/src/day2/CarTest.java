package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void testhashcode() {
		Car car= new Car("Honda","City","VX",2024,7);
		int hash = car.hashCode();
		System.out.println(car+" "+car.hashCode());
		assertEquals(hash,car.hashCode());
		assertEquals(hash, new Car("Honda","City","VX",2024,7).hashCode());
		car.setVariant("ZS");
		System.out.println(car+" "+car.hashCode());
		assertNotEquals(hash,car.hashCode());
		car.setVersion(6);
	}
	
	@Test
	void testToString() {
		Car car= new Car("Honda","City","VX",2024,7);
		assertEquals("Honda City VX 2024 Version 7",car.toString());
		car.setVariant("ZS");
		assertEquals("Honda City ZS 2024 Version 7",car.toString());
		car.setVersion(6);
		assertEquals("Honda City ZS 2024 Version 6",car.toString());
	}
	
	@Test
	void testClone()throws Exception {
		Car car= new Car("Honda","City","VX",2024,7);
		Car car1= (Car)car.clone();
		assertEquals(car, car1);
		assertNotSame(car, car1);
	}

}
