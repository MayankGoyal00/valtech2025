package Inassignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;
import java.util.Set;

public class ItemDAOImpl implements ItemDAO {
	

    private SessionFactory sessionFactory;  
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public void save(Item item) {
    	new HibernateTemplate(sessionFactory).save(item);
    	
    }
    
    @Override
    public void update(Item i) {
    	new HibernateTemplate(sessionFactory).update(i);
    	
    }

	@Override
	public void delete(Long itemId) {
		new HibernateTemplate(sessionFactory).delete(get(itemId));		
	}

	@Override
	public Item get(Long itemId) {
		return new HibernateTemplate(sessionFactory).load(Item.class, itemId);	
		
	}
    
	@Override
	public Set<Item> findAll() {
		return (Set<Item>) new HibernateTemplate(sessionFactory).find("Item i");
	
	}


}