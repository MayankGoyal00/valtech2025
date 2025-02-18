package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import day4.Employee.Gender;

class EmployeeTest {

//	@Test
//	void testHashCode() {
//		Employee emp = Employee.builder().id(1).name("mayank").age(20).salary(1000).level(0).experience(1).build();
//		Employee emp1 = Employee.builder().id(2).name("abcd").age(40).salary(4000).level(2).experience(2).build();
//		Employee emp2 = Employee.builder().id(1).name("mayank").age(20).salary(1000).level(0).experience(1).build();
//		assertEquals(emp.hashCode(), emp2.hashCode());
//		assertNotEquals(emp.hashCode(), emp1.hashCode());
//		
//	}
//
//	@Test
//	void testEqualsObject() {
//		Employee emp = Employee.builder().id(1).name("mayank").age(20).salary(1000).level(0).experience(1).build();
//		Employee emp1 = Employee.builder().id(2).name("abcd").age(40).salary(4000).level(2).experience(2).build();
//		Employee emp2 = Employee.builder().id(1).name("mayank").age(20).salary(1000).level(0).experience(1).build();
//		assertTrue(emp.equals(emp2));
//		assertFalse(emp.equals(emp1));
//	}
	@Test
	void testAll() {
		Employee.builder().id(1).name("abc").age(10).salary(1000).level(1).experience(1).gender(Gender.MALE).build();
		Employee.builder().id(2).name("mayank").age(20).salary(2000).level(2).experience(2).gender(Gender.FEMALE).build();
		Employee.builder().id(3).name("abc").age(30).salary(3000).level(3).experience(3).gender(Gender.OTHER).build();
		Employee.builder().id(4).name("abcd").age(40).salary(4000).level(4).experience(4).gender(Gender.MALE).build();
		Employee.builder().id(5).name("abcde").age(50).salary(5000).level(5).experience(5).gender(Gender.FEMALE).build();
		Employee.builder().id(6).name("abcdef").age(60).salary(6000).level(6).experience(6).gender(Gender.OTHER).build();
		Employee.builder().id(7).name("abcdefg").age(70).salary(7000).level(7).experience(7).gender(Gender.MALE).build();
		Employee.builder().id(8).name("abcdefgh").age(80).salary(8000).level(8).experience(8).gender(Gender.FEMALE).build();
		Employee.builder().id(9).name("abcdefghi").age(90).salary(9000).level(9).experience(9).gender(Gender.OTHER).build();
		Employee.builder().id(10).name("abcdefghij").age(100).salary(10000).level(10).experience(10).gender(Gender.MALE).build();
		System.out.println("\n");

		//assertEquals(1,(emp.compareTo(emp1)));
		//assertNotEquals(1,(emp.compareTo(emp2)));
		
		
		Collections.sort(Employee.allEmp);
		for (Employee em : Employee.allEmp) {
			System.out.println(em);
		}
		
		double emp1=Employee.getemployeebylevel(1);
		System.out.println(" by LEvel"+emp1);
		
		double emp2=Employee.getemployeebygender(Gender.OTHER);
		System.out.println(" by GEnder = "+emp2);
		
		String emp3=Employee.getemployeebyname("samosa chole ");
		System.out.println(" by NAme = "+ emp3);
		
		double emp4=Employee.getemployeebygenderlevel(4,Gender.MALE);
		System.out.println(" by GEnder and LEvel"+ emp4);
		
		Map<Gender,List<Employee>> emp5=Employee.getemployeebygender();
		System.out.println(emp5);
		
	}
	
	
	
	
	
	
}
