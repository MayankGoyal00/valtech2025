package com.valtech.training.CustomerOrderMVC.services;

import java.util.List;
import java.util.Set;

import com.valtech.training.CustomerOrderMVC.entities.Item;
import com.valtech.training.CustomerOrderMVC.vos.ItemVO;

public interface ItemService {
	
	ItemVO saveItem(ItemVO ivo);	
	ItemVO updateItem(int id, ItemVO ivo);	
	ItemVO getItem(int id);
	List<ItemVO> getAllItems();
	void updateInventory(int itemId, int newQuantity);
	void resetInventory(Item item);
 
}
