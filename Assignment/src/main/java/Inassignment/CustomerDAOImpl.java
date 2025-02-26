package Inassignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void addCustomer(Customer customer) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();

	}

	@Override
	public void removeCustomer(long id) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        if (customer != null) {
            session.delete(customer);
        }
        transaction.commit();
        session.close();

	}

	@Override
	public Customer getCustomerById(long id) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = HibernateClient.getSessionFactory().openSession();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
        session.close();
        return customers;
	}

}
