package Inassignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;
import java.util.Set;

public class OrderDAOImpl implements OrderDAO {
	
    private SessionFactory sessionFactory;  
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public void save(Orders o) {
    	new HibernateTemplate(sessionFactory).save(o);
    	
    }
    
    @Override
    public void update(Orders oo) {
    	new HibernateTemplate(sessionFactory).update(oo);
    	
    }

	@Override
	public void delete(Long orderId) {
		new HibernateTemplate(sessionFactory).delete(get(orderId));		
	}

	@Override
	public Orders get(Long orderId) {
		return new HibernateTemplate(sessionFactory).load(Orders.class, orderId);	
		
	}
    
	@Override
	public Set<Orders> findAll() {
		return (Set<Orders>) new HibernateTemplate(sessionFactory).find("Order o");
	
	}

}