package Inassignment;

import java.util.List;
import java.util.Set;

public interface ItemDAO {
    void save(Item item);
    void update(Item i);
    void delete(Long itemId);   
    Item get(Long itemId);  
    Set<Item> findAll();
//	void updateItem(int itemId, int newQuantity);
   
}

