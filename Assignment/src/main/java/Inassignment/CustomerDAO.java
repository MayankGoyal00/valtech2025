package Inassignment;

import java.util.List;

public interface CustomerDAO {
	void addCustomer(Customer customer);
    void removeCustomer(long id);
    Customer getCustomerById(long id);
    List<Customer> getAllCustomers();
}
