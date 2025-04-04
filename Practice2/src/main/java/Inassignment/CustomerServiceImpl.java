package Inassignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
    public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
    public void save(Customer c) {
    	customerDAO.save(c);
    	
    }
    
    @Override
    public void update(Customer c) {
    	customerDAO.update(c);
    	
    }

	@Override
	public void delete(Long customerId) {
		customerDAO.delete(customerId);		
	}

	@Override
	public Customer get(Long customerId) {
		return customerDAO.get(customerId);	
		
	}
    
	@Override
	public Set<Customer> findAll() {
		return customerDAO.findAll();
	
	}

	
    

}