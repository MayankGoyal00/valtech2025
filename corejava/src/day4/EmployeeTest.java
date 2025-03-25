package day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import day4.Employee.Gender;

class EmployeeTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setup() {
        employeeService = new EmployeeService();

        Employee.builder().id(1).name("abc").age(10).salary(1000).level(1).experience(1).gender("MALE").build();
        Employee.builder().id(2).name("mayank").age(20).salary(2000).level(2).experience(2).gender("MALE").build();
        Employee.builder().id(3).name("abc").age(30).salary(3000).level(3).experience(3).gender("OTHER").build();
        Employee.builder().id(4).name("abcd").age(40).salary(4000).level(4).experience(4).gender("MALE").build();
        Employee.builder().id(5).name("abcde").age(50).salary(5000).level(5).experience(5).gender("FEMALE").build();
        Employee.builder().id(6).name("abcdef").age(60).salary(6000).level(6).experience(6).gender("OTHER").build();
        Employee.builder().id(7).name("abcdefg").age(70).salary(7000).level(7).experience(7).gender("MALE").build();
        Employee.builder().id(8).name("abcdefgh").age(80).salary(8000).level(8).experience(8).gender("FEMALE").build();
        Employee.builder().id(9).name("abcdefghi").age(90).salary(9000).level(9).experience(9).gender("OTHER").build();
        Employee.builder().id(10).name("abcdefghij").age(100).salary(10000).level(10).experience(10).gender("MALE").build();
        
        employeeService.printSortedEmployees();
        
    }

    @Test
    void testEmployeeService() {

    	
        double totalSalaryLevel = employeeService.getEmployeeByLevel(1);
        System.out.println("Total Salary Level =" + totalSalaryLevel);
        assertEquals(1000,totalSalaryLevel,.1);

        double totalSalaryFemale = employeeService.getEmployeeByGender(Gender.FEMALE);
        System.out.println("Total Salary FEMALE=" + totalSalaryFemale);
        assertEquals(13000,totalSalaryFemale,.1);

        String employeeNames =employeeService.getEmployeeByName("mayank");
        System.out.println("Employee with name 'mayank'" + employeeNames);
        assertEquals(employeeNames,(new Employee(2l,"mayank",20,2000,2,2,Gender.MALE)).toString());

        double totalSalaryMaleLevel = employeeService.getEmployeeByGenderAndLevel(4, Gender.MALE);
        System.out.println("Total Salary forr MALE and Level  =" + totalSalaryMaleLevel);
        assertEquals(4000,totalSalaryMaleLevel,.1);
       
    }
}


