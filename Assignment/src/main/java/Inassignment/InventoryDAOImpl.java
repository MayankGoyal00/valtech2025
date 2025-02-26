package Inassignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InventoryDAOImpl implements InventoryDAO {

	@Override
	public void addItem(Item item) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();

	}

	@Override
	public void removeItem(long id) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.get(Item.class, id);
        if (item != null) {
            session.delete(item);
        }
        transaction.commit();
        session.close();

	}

	@Override
	public void updateItem(Item item) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();

	}

	@Override
	public Item getItemById(long id) {
		Session session = HibernateClient.getSessionFactory().openSession();
        Item item = session.get(Item.class, id);
        session.close();
        return item;
	}

	@Override
	public List<Item> getAllItems() {
		Session session = HibernateClient.getSessionFactory().openSession();
        List<Item> items = session.createQuery("from Item", Item.class).list();
        session.close();
        return items;

}
