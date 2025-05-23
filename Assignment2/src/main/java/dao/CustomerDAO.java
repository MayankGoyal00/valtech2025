package dao;

import java.util.List;

import classes.Customer;

public interface CustomerDAO {
	
	void save(Customer c);
	void update(Customer c);
	void delete(int id);
	Customer get(int id);
	List<Customer> getAll();
}
