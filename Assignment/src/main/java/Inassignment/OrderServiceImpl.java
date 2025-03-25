package Inassignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;
import java.util.Set;

public class OrderServiceImpl implements OrderDAO {
	
	@Autowired
	private OrderDAO orderDAO;
    public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	} 
    @Override
    public void update(Orders oo) {
    	orderDAO.update(oo);
    	
    }
	@Override
	public void delete(Long orderId) {
		orderDAO.delete(orderId);		
	}
	@Override
	public Orders get(Long orderId) {
		return orderDAO.get(orderId);	
		
	}
	@Override
	public Set<Orders> findAll() {
		return orderDAO.findAll();
	}
	@Override
	public void save(Orders o) {
		orderDAO.save(o);
	
	}
}