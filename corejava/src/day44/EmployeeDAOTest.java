package day44;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import day4.Employee;
import day4.Employee.Gender;



class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao=new EmployeeDAOimpl();
		dao.save(new Employee(2,"Working",24, 11000,3,1,Gender.FEMALE));
		Employee e=new Employee(1,"DEF",23,12500,5,2,Gender.MALE);
		dao.update(e);
		//e=dao.get(1);
		assertEquals(1,e.getId());
		assertEquals("DEF",e.getName());
		assertEquals(23,e.getAge());
		assertEquals(12500,e.getSalary());
		assertEquals(5,e.getLevel());
		assertEquals(2,e.getExperience());
		assertEquals(Gender.MALE,e.getGender());
		assertTrue(dao.getAll().size()>1);
		dao.delete(2);
	}

}

