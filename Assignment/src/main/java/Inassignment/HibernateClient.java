package Inassignment;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.List;
import Inassignment.Item;
import Inassignment.Order;
import Inassignment.Customer;
import Inassignment.LineItem;

public class HibernateClient {
	//private static final SessionFactory sessionFactory;

    static {
        try {
        		SessionFactory sesFac=new AnnotationConfiguration()
           // sessionFactory = new Configuration().configure("hibernate.cfg.xml")   ///
                .addAnnotatedClass(Inassignment.Item.class)
                .addAnnotatedClass(Inassignment.Order.class)
                .addAnnotatedClass(Inassignment.Customer.class)
                .addAnnotatedClass(Inassignment.LineItem.class)
                .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
//
//
//package Inassignment;
//
//public class OrderManagementSystem {
//	public static void main(String[] args) {
//        // Initialize DAOs and Services
//        InventoryDAO inventoryDAO = new InventoryDAOImpl();
//        OrderDAO orderDAO = new OrderDAOImpl();
//        CustomerDAO customerDAO = new CustomerDAOImpl();
//
//        InventoryService inventoryService = new InventoryServiceImpl(inventoryDAO);
//        OrderService orderService = new OrderServiceImpl(orderDAO);
//        CustomerService customerService = new CustomerServiceImpl(customerDAO);
//
//        // Example Operations
//        Item newItem = new Item();
//        newItem.setName("Laptop");
//        newItem.setDescription("Gaming Laptop");
//        newItem.setQuantity(50);
//        newItem.setReorder_level(10);
//        newItem.setMax_quantity(100);
//        inventoryService.addItem(newItem);
//
//        Customer customer = new Customer();
//        customer.setName("John Doe");
//        customer.setAge(25);
//        customer.setAddress("123 Main St");
//        customer.setP_address("456 Elm St");
//        customerService.addCustomer(customer);
//
//        Order order = new Order();
//        order.setCustomerId(customer.getId());//setCustomer_id
//        orderService.placeOrder(order);
//    }
//}
//
//
//
//
//
