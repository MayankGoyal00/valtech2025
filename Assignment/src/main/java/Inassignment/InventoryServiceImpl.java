package Inassignment;

import java.util.List;
//import dao.InventoryDAO;/////
//import dao.impl.InventoryDAOImpl;//////

public class InventoryServiceImpl implements InventoryService{

	private InventoryDAO inventoryDAO;
	
	public InventoryServiceImpl(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

	@Override
	public void addItem(Item item) {
		inventoryDAO.addItem(item);
		
	}

	@Override
	public void removeItem(long id) {
		inventoryDAO.removeItem(id);
		
	}

	@Override
	public void updateItem(Item item) {
		inventoryDAO.updateItem(item);
		
	}

	@Override
	public Item getItemById(long id) {
		return inventoryDAO.getItemById(id);
	}

	@Override
	public List<Item> getAllItem() {
		return inventoryDAO.getAllItems();
	}

}
