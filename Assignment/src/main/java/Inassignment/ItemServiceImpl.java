package Inassignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;
import java.util.Set;

public class ItemServiceImpl implements ItemDAO {
	
	private ItemDAO itemDAO;
    public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	} 
  
    @Override
    public void save(Item item) {
    	itemDAO.save(item);
    	
    }
    
    @Override
    public void update(Item i) {
    	itemDAO.update(i);
    	
    }

	@Override
	public void delete(Long itemId) {
		itemDAO.delete(itemId);		
	}

	@Override
	public Item get(Long itemId) {
		return itemDAO.get(itemId);	
		
	}
    
	@Override
	public Set<Item> findAll() {
		return itemDAO.findAll();
	
	}

}