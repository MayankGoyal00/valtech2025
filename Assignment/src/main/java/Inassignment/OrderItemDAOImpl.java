package Inassignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;
import java.util.Set;

public class OrderItemDAOImpl implements OrderItemDAO {
	

    private SessionFactory sessionFactory;  
    
    public void setSessionFactory(SessionFactory seesionFactory) {
    	this.sessionFactory =sessionFactory;
    }
    
    @Override
    public void save(OrderItem oi) {
    	new HibernateTemplate(sessionFactory).save(oi);
    	
    }
    
    @Override
    public void update(OrderItem oi) {
    	new HibernateTemplate(sessionFactory).update(oi);
    	
    }

	@Override
	public void delete(Long oiId) {
		new HibernateTemplate(sessionFactory).delete(get(oiId));		
	}

	@Override
	public OrderItem get(Long oiId) {
		return new HibernateTemplate(sessionFactory).load(OrderItem.class, oiId);	
		
	}
    
	@Override
	public List<OrderItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("OrderItem oi");
	
	}

	
    

}