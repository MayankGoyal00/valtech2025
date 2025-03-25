package Inassignment;

import java.util.List;
import java.util.Set;

public interface ItemService {
    void save(Item item);
    void update(Item i);
    void delete(Long itemId);   
    Item get(Long itemId);  
    Set<Item> findAll();
	
//	void resetItem(Item item);
//	void updateItem(int itemid, int newQuantity);
   
}

