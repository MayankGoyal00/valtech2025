package day44;

import java.util.List;

import day4.Employee;

public interface EmployeeDAO {
	
	void save(Employee e);
	void update(Employee e);
	void delete(int id);
	Employee get(int id);
	List<Employee> getAll();
	
	
}
