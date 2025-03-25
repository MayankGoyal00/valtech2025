package com.valtech.training.CustomerOrderMVC.services;

import java.util.List;

import com.valtech.training.CustomerOrderMVC.vos.ItemVO;
import com.valtech.training.CustomerOrderMVC.vos.LineItemVO;
 
public interface LineItemService {
	LineItemVO saveLineItem(LineItemVO livo); 
	LineItemVO updateLineItem(int id, LineItemVO livo);	 
	LineItemVO getLineItem(int id);	 
	List<LineItemVO> getAllLineItems();
	void savelineItem(ItemVO iv);
}