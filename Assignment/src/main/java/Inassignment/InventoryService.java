package Inassignment;

import java.util.List;

public interface InventoryService {
	
	void addItem(Item item);
	void removeItem(long id);
	void updateItem(Item item);
	Item getItemById(long id);
	List<Item> getAllItem();

}
