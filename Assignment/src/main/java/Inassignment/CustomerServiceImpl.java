package Inassignment;

//import dao.CustomerDAO;///
//import dao.impl.CustomerDAOImpl;///
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    
	@Override
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);

	}

	@Override
	public void removeCustomer(long id) {
		customerDAO.removeCustomer(id);
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerDAO.getCustomerById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

}
