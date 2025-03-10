package spring.Tx;

import java.util.List;

import spring.Tx.Employee;

public interface EmployeeDAO {
	
	void save(Employee e);
	void update(Employee e);
	void delete(int id);
	Employee get(int id);
	List<Employee> getAll();
	
	
}
