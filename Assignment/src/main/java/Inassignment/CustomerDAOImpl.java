package Inassignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;
import java.util.Set;

public class CustomerDAOImpl implements CustomerDAO {
	
    private SessionFactory sessionFactory;  
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public void save(Customer c) {
    	new HibernateTemplate(sessionFactory).save(c);
    	
    }
    
    @Override
    public void update(Customer c) {
    	new HibernateTemplate(sessionFactory).update(c);
    	
    }

	@Override
	public void delete(Long customerId) {
		new HibernateTemplate(sessionFactory).delete(get(customerId));		
	}

	@Override
	public Customer get(Long customerId) {
		return new HibernateTemplate(sessionFactory).load(Customer.class, customerId);	
		
	}
    
	@Override
	public Set<Customer> findAll() {
		return (Set<Customer>) new HibernateTemplate(sessionFactory).find("Customer c");
	
	}

	
    

}