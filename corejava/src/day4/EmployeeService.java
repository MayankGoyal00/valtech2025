package day4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {

	
    public double getEmployeeByLevel(int level) {
        return Employee.allEmp.stream()
                .filter(emp -> emp.getLevel() == level)
                .mapToDouble(emp->emp.getSalary())
                .sum(); 
    }

    public double getEmployeeByGender(Employee.Gender gender) {
        return Employee.allEmp.stream()
                .filter(emp -> emp.getGender() == gender) 
                .mapToDouble(emp->emp.getSalary())
                .sum(); 
    }

    public String getEmployeeByName(String name) {
        return Employee.allEmp.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .map(emp->emp.toString())
                .collect(Collectors.joining(", "));
    }

    public double getEmployeeByGenderAndLevel(int level, Employee.Gender gender) {
        return Employee.allEmp.stream()
                .filter(emp -> emp.getLevel() == level && emp.getGender() == gender)
                .mapToDouble(emp->emp.getSalary())
                .sum();
    }

    public Map<Employee.Gender, List<Employee>> getEmployeeByGender() {
        return Employee.allEmp.stream()
                .collect(Collectors.groupingBy(emp->emp.getGender()));
    }
    
    public void printSortedEmployees() {
      Employee.allEmp.stream()
              .sorted()
              .forEach(emp->System.out.println(emp));
    }

   
}


