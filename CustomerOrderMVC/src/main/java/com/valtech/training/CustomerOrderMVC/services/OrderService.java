package com.valtech.training.CustomerOrderMVC.services;

import java.util.List;

import com.valtech.training.CustomerOrderMVC.enums.OrderStatus;
import com.valtech.training.CustomerOrderMVC.repos.ItemRepo;
import com.valtech.training.CustomerOrderMVC.repos.OrderRepo;
import com.valtech.training.CustomerOrderMVC.vos.OrderVO;
 
public interface OrderService {
	OrderVO placeOrder(OrderVO orderVO); 
	void updateOrderStatus(int orderId, OrderVO orderVO);	 
	OrderVO getOrderById(int orderId);	 
	List<OrderVO> getAllOrders();	 
	void setItemRepo(ItemRepo itemRepo);	 
	void setOrderRepo(OrderRepo orderRepo);
	void updateOrderStatus(int orderId, OrderStatus status);
}