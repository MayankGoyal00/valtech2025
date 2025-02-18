package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import day4.Employee.Gender;

class EmployeeRecordTest {

	@Test
	void test() {

		EmployeeRecord er =new EmployeeRecord(1 ,"Abc",23 ,Gender.MALE ,12000 ,5 ,2);
		assertEquals(1,er.id());
		assertEquals("Abc",er.name());
		assertEquals(Gender.MALE,er.gender());
		assertEquals(12000,er.salary());
		assertEquals(5,er.experience());
		assertEquals(2,er.level());
		System.out.println(er);
		
		EmployeeRecord er1 =new EmployeeRecord(1 ,"Abc",23 ,Gender.MALE ,12000 ,5 ,2);
		//System.out.println(er);
		assertEquals(er.hashCode(),er1.hashCode());
		assertEquals(er, er1);
		
		EmployeeRecord er2 =new EmployeeRecord(2 ,"bbc",23 ,Gender.MALE ,12000 ,5 ,2);
		//System.out.println(er2);
		assertFalse(er1.hashCode() == er2.hashCode());
		assertNotEquals(er, er2);
		assertEquals(2500, er.computeBonus());
	}

}
