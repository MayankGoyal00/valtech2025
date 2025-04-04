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
public class ItemServiceImpl implements ItemDAO {
	
	@Autowired
	private ItemDAO itemDAO;
	
//	@Override
//	public void updateItem(int itemId,int newQuantity) {
//		Item item = itemDAO.get(itemId);
//        
//        if (item != null) {
//            item.setCurrentQuantity(newQuantity);
//            item.setReorderQuantity(Math.max(item.getMaxQuantity() - newQuantity, 0)); 
//            
//            itemDAO.update(item);
//            }
//		
//	}
//
//	@Override
//	public void resetItem(Item item) {
//		item.setCurrentQuantity(item.getMaxQuantity());
//		item.setReorderQuantity(0);
//		itemDAO.update(item);
//	}
//	
//	public void setItemDAO(ItemDAO itemDAO) {
//		this.itemDAO = itemDAO;
//	}
//	
	
	
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