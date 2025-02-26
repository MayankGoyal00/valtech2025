package Inassignment;

import java.util.List;
//import dao.OrderDAO;////
//import dao.impl.OrderDAOImpl;////

public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	
	public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
	
	@Override
	public void placeOrder(Order order) {
		orderDAO.placeOrder(order);

	}

	@Override
	public void checkOrderStatus(long orderId) {
		orderDAO.checkOrderStatus(orderId);
	}

	@Override
	public void reorderItem(long Id) {
		orderDAO.reorderItem(orderId);

	}

	@Override
	public void addOrder(Order order) {
		orderDAO.addOrder(order);

	}

	@Override
	public void removeOrder(long orderId) {
		orderDAO.removeOrder(orderId);

	}

	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

}
