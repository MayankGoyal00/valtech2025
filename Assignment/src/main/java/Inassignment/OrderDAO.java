package Inassignment;

import java.util.List;

public interface OrderDAO {
	 void placeOrder(Order order);
	 void checkOrderStatus(long orderId);
	 void reorderItem(long orderId);
     void addOrder(Order order);
     void removeOrder(long orderId);
	 List<Order> getAllOrders();
}
