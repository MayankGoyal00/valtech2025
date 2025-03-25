package com.valtech.training.CustomerOrderMVC.services;

import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
import com.valtech.training.CustomerOrderMVC.entities.Item;
import com.valtech.training.CustomerOrderMVC.entities.LineItem;
import com.valtech.training.CustomerOrderMVC.entities.Order;
import com.valtech.training.CustomerOrderMVC.enums.OrderStatus;
import com.valtech.training.CustomerOrderMVC.repos.ItemRepo;
import com.valtech.training.CustomerOrderMVC.repos.OrderRepo;
import com.valtech.training.CustomerOrderMVC.vos.OrderVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
	@Autowired
	    private OrderRepo orderRepo;
	    
	    @Autowired
	    private ItemRepo itemRepo;
	
	    
	    @Override
	public OrderVO placeOrder(OrderVO orderVO) {
	Order order = orderVO.to();
	        
	        for(LineItem lineItem : order.getLineItems()) {
	            Item item = itemRepo.getReferenceById(lineItem.getItem().getId());
	            
	            if(item == null) {
	                throw new RuntimeException("Item not found with ID: " + lineItem.getItem().getId());
	            }
	            
	            int updatedQuantity = item.getQuantity() - lineItem.getQuantity();
	            
	            if(updatedQuantity < 0) {
	                throw new RuntimeException("Not enough stock available for item : " + item.getName());
	            }
	            
	            item.setQuantity(updatedQuantity);
	            itemRepo.save(item);
	        }
	        
	        orderRepo.save(order);
			return orderVO;
	    }
	
	    
	    @Override
	public void updateOrderStatus(int orderId, OrderStatus status) {
	        Order order = orderRepo.getReferenceById(orderId);
	        
	        if(order != null) {
	            order.setStatus(status);
	            orderRepo.save(order);
	        } else {
	            throw new RuntimeException("Order not found with ID: " + orderId);
	        }
	    }
	
	
	    @Override
	public OrderVO getOrderById(int orderId) {
	        Order order = orderRepo.getReferenceById(orderId);
	        return OrderVO.from(order);
	    }
	
	   
	    @Override
	public List<OrderVO> getAllOrders() {
	        return orderRepo.findAll().stream()
	                        .map(OrderVO::from)  
	                        .collect(Collectors.toList());
	    }
	    
	    @Override
	public void setItemRepo(ItemRepo itemRepo) {
	        this.itemRepo = itemRepo;
	    }
	
	    @Override
	public void setOrderRepo(OrderRepo orderRepo) {
	        this.orderRepo = orderRepo;
	    }


		@Override
		public void updateOrderStatus(int orderId, OrderVO orderVO) {
			// TODO Auto-generated method stub
			
		}
}
 