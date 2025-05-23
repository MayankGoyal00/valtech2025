package dao;

import java.util.List;


public interface EmployeeDAO {
	
	void save(Employee e);
	void update(Employee e);
	void delete(int id);
	Employee get(int id);
	List<Employee> getAll();
	List<Employee> searchByName(String name);
	List<Employee> searchByAge(int age, String condition);
	List<Employee> searchByGender(String gender);
	
	List<Employee> searchBySalary(float salary, String condition);
	
	List<Employee> searchByLevel(int level,String condition);
	
	List<Employee> searchByExperience(int ex,String condition);
	
	List<Employee> searchById(long id);
	List<Employee> sortEmployees(String column,String order);
	
	
}