package hibernate.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import classes.Customer;
import classes.Item;
import classes.LineItem;
import classes.Order;
import classes.Order.ORDERSTATUS;
import dao.ItemDAO;
import dao.LineItemDAO;
import dao.OrderDAO;
import services.CustomerService;
import services.InventoryService;
import services.OrderService;

public class HibernateClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hhibernate.xml");
		CustomerService customerservice = context.getBean(CustomerService.class);
		ItemDAO itemdao = context.getBean(ItemDAO.class);
		OrderDAO orderdao = context.getBean(OrderDAO.class);
        OrderService orderservice = context.getBean(OrderService.class);
        LineItemDAO ld = context.getBean(LineItemDAO.class);
        InventoryService inventoryservice = context.getBean(InventoryService.class);
 
        
//        Customer customer1 = new Customer("Emma Watson", 30, "Los Angeles", "New York");
//        customerservice.save(customer1);
//        Customer customer2 = new Customer("Sandeep Sharma", 35, "Delhi", "Chennai");
//        customerservice.save(customer2);
//        Customer customer3 = new Customer("Olivia Smith", 28, "Portland", "Miami");
//        customerservice.save(customer3);
//        Customer customer4 = new Customer("Arjun Patel", 27, "Mumbai", "Bangalore");
//        customerservice.save(customer4);
//        Customer customer5 = new Customer("Isabella Rossi", 38, "Rome", "Milan");
//        customerservice.save(customer5);
//        Customer customer6 = new Customer("James Thompson", 22, "San Diego", "Los Angeles");
//        customerservice.save(customer6);
//        Customer customer7 = new Customer("Ayesha Khan", 27, "Karachi", "Lahore");
//        customerservice.save(customer7);
//        Customer customer8 = new Customer("Virat Kholi", 36, "Bangalore", "Delhi");
//        customerservice.save(customer8);
 //       Customer customer9 = new Customer("Sanju Samson", 33, "karnataka", "Assam");
//        customerservice.save(customer9);
//        Customer customer10 = new Customer("Ben Stokes", 44, "England", "Neatherland");
//        customerservice.save(customer10);
//       
//
//        Item item1 = new Item("Chips", "Lays Classic", 10, 5, 20);
//        itemdao.save(item1);
//        Item item2 = new Item("Smartwatch", "Apple Watch Series 7", 40, 12, 100);
//        itemdao.save(item2);
//        Item item3 = new Item("Wireless Mouse", "Logitech MX Master 3", 25, 8, 40);
//        itemdao.save(item3);
//        Item item4 = new Item("Biscuits", "McVitie's Digestive", 45, 20, 90);
//        itemdao.save(item4);
//        Item item5 = new Item("Laptop", "HP Spectre x360", 120, 10, 250);
//        itemdao.save(item5);
//        Item item6 = new Item("Monitor", "Dell 27-inch 4K", 180, 30, 350);
//        itemdao.save(item6);
//        Item item7 = new Item("Boom", "Blast in Air", 25, 8, 50);
//        itemdao.save(item7);
//        Item item8 = new Item("Neo6M", "GPS", 45, 20, 90);
//        itemdao.save(item8);
 //         Item item9 = new Item("Air Gun", "Firee in Air", 100, 10, 250);
//        itemdao.save(item9);
//        Item item10 = new Item("Phone", "Samsung Smart Phone", 180, 30, 300);
//        itemdao.save(item10);
//        Item item11 = new Item("Bat", "Play Cricket", 280, 40, 400);
//        itemdao.save(item11);
//        
        
        
//
//        Customer customer = customerservice.get(2); 
//        Item item = itemdao.get(2); 
//
//        LineItem lineItem = new LineItem();
//        lineItem.setItem(item);
//        lineItem.setQuantity(7);
//
//        Order order = new Order();
//        order.setCustomer(customer);
//        order.setStatus(ORDERSTATUS.BOOKED);
//        order.addLineItem(lineItem);
//
//        orderservice.placeOrder(order);
//        System.out.println("Order placed " + order);
//  
        
        
        
//        Order obj = orderdao.getOrderById(2);  
//        orderservice.updateOrderStatus(obj.getOrderId(), ORDERSTATUS.DISPATCHED);
//        System.out.println("Order status updated for the order ID " + obj.getOrderId());
        
        
//
//       
//        Item obj1 = itemdao.get(2); 
//        System.out.println("Updated inventory for this item " + obj1);
        

//**********

        
//        Customer c = customerservice.get(10); 
//        c.setName("Ben Stokes");  
//        c.setAge(44); 
//        customerservice.update(c);

        
//        Customer c = customerservice.get(10);
//        customerservice.delete(10);
        
//        Customer c = customerservice.get(10);
//        System.out.println(c);
        
//        List<Customer> allCustomers = customerservice.getAll();
//        System.out.println(allCustomers);
//        
        
//       context.close();
        
        
//**********
        
        
//        Item i = itemdao.get(11);
//        System.out.println(i);
        
//        Item i = itemdao.get(11);
//        i.setQuantity(281);
//        itemdao.update(i);
        
//        Item i = itemdao.get(11);
//        itemdao.delete(11);
        
//        List<Item> all = itemdao.getAll();
//        System.out.println(all);
        
        
//**********
      //void resetInventory(Item item);
      //void updateInventory(int itemid,int newQuantity);
        

//          Item i = new Item("Chips", "Lays Classic", 10, 5, 20);
//        	itemdao.save(i);
//          inventoryservice.resetInventory(i); 
        

//        int it = 1;
//        int newQuantity = 5;  
//        inventoryservice.updateInventory(it, newQuantity);
        
//**********        
        

//        Item item1 = itemdao.get(1);  
//        Customer customer1 = customerservice.get(1);  
//        
//        LineItem lineItem1 = new LineItem();
//        lineItem1.setItem(item1);
//        lineItem1.setQuantity(2);
//        
//        ld.save(lineItem1);  
//
//        // Update the LineItem 
//        LineItem lineItemToUpdate = ld.getById(1);  
//         lineItemToUpdate.setQuantity(10);  
//         ld.update(lineItemToUpdate);  
//        
//
//        ld.delete(1);  
//        
//        LineItem li = ld.getById(2);  
//
//        List<LineItem> allLi = ld.getAll(); 
        
//        int orderId = 1;  
//        List<LineItem> liByOrderId = ld.getByOrderId(orderId);
//        System.out.println(liByOrderId);
        
        
//**********    
//        Customer c = customerservice.get(9);
//        Item i = itemdao.get(9);
//
//        
//        LineItem lineItem = new LineItem();
//        lineItem.setItem(i);
//        lineItem.setQuantity(3);
//        
//        
//      Creating  Order
//        Order o = new Order();
//        o.setCustomer(c);
//        o.setStatus(ORDERSTATUS.BOOKED);  
//        o.addLineItem(lineItem); 
//        
//        orderservice.placeOrder(o);
        
//**********         

//        Customer customer = customerservice.get(2); 
//        Item item = itemdao.get(2); 
//
//        LineItem lineItem = new LineItem();
//        lineItem.setItem(item);
//        lineItem.setQuantity(7);
//
//        Order order = new Order();
//        order.setCustomer(customer);
//        order.setStatus(ORDERSTATUS.BOOKED);
//        order.addLineItem(lineItem);
//
//        orderservice.placeOrder(order);
//        System.out.println("Order placed " + order);
        
        
       
	}
}






//void save(LineItem lineItem);                
//void update(LineItem lineItem);               
//void delete(int id);              
//LineItem getById(int id);              
//List<LineItem> getAll();                     
//List<LineItem> getByOrderId(int orderId);  


//void save(Order o);
//void update(Order o);
//Order getOrderById(int id);
//List<Order> getAll();


//void placeOrder(Order order);
//void updateOrderStatus(int orderId,ORDERSTATUS status);
//Order getOrderById(int orderId);
//List<Order> getAllOrders();


