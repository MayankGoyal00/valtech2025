package Inassignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void placeOrder(Order order) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();

	}

	@Override
	public void checkOrderStatus(long orderId) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Order order = session.get(Order.class, orderId);
        System.out.println(order);
        session.close();

	}

	@Override
	public void reorderItem(long orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addOrder(Order order) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
	}

	@Override
	public void removeOrder(long orderId) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, orderId);
        if (order != null) {
            session.delete(order);
        }
        transaction.commit();
        session.close();

	}

	@Override
	public List<Order> getAllOrders() {
		Session session = HibernateClient.getSessionFactory().openSession();
        List<Order> orders = session.createQuery("from Order", Order.class).list();
        session.close();
        return orders;
	}

}
