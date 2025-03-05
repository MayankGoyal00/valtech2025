package Inassignment;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateClient {
    public static void main(String[] args) {
    	
 
    	ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("hibernate.xml");//spring
    	CustomerService cs= ctx.getBean(CustomerServiceImpl.class);
    	CustomerDAO csh=ctx.getBean(CustomerDAOImpl.class);
    	OrderDAO oh= ctx.getBean(OrderDAOImpl.class);
    	ItemDAO idao= ctx.getBean(ItemDAOImpl.class);
    	

//    	csh.delete(1l);
//   	csh.delete(2l);
//    	csh.delete(3l);
    	

    	
    	
    	
 //   	Item i = new Item("bottle","sports",10,2,20);
//    	Item i=new Item();
//    	i.setName("Ball");
//    	i.setDescription("Tennis");
//    	i.setCurrentQuantity(20);
//    	i.setReorderQuantity(10);
//    	i.setMaxQuantity(40);
 //   	idao.save(i);
    	
    	Item i2=new Item();
    	i2.setName("gloves");
    	i2.setDescription("Golf");
    	i2.setCurrentQuantity(30);
    	i2.setReorderQuantity(20);
    	i2.setMaxQuantity(50);
 //   	idao.save(i2);
    	
//    	Item i3=new Item();
//    	i3.setName("ball");
//    	i3.setDescription("football");
//    	i3.setCurrentQuantity(150);
//    	i3.setReorderQuantity(50);
//    	i3.setMaxQuantity(300);
//    	idao.save(i3);
    	
    	
    	
    	
    	
 //   	Customer c1=new Customer("Mayank",23,"Gujarat","Rajasthan");
 //   	csh.save(c1);
 //   	Customer c2=new Customer("Mitul",22,"Kolkata","Gujarat");
 //   	csh.save(c2);
    	Customer c3=new Customer("Abishek",20,"Punjab","Uttrakhand");
    	csh.save(c3);
//    	Customer c4=new Customer("Rahul",32,"Himchal","Rajasthan");
//    	csh.save(c4);
//    	Customer c5=new Customer("Virat",30,"Delhi","Haryana");
//    	csh.save(c5);
    	
    	
    	
    	
    	
    	
    	Orders ob= new Orders();
    	ob.addOrderItems(new OrderItem(i2,ob,90));
    	ob.setCustomer(c3);
    	ob.setOrderStatus("PACKed");
    	oh.save(ob);
    	
    	
    	
   	
    	
//    	Orders ob= new Orders();
//    	ob.addOrderItems(new OrderItem(i3,ob,990));
//    	oh.save(ob);
    	
//
    	
    	Orders ob2= new Orders();
    	ob2.addOrderItems(new OrderItem(i2,ob,900));
    	oh.save(ob2);
    	
    	
    	
    	
    	
    	
//    	OrderItem oi= new OrderItem();
//    	oi.setItem(is.get(3));
//    	oi.setQuantity(25);
//    	
//    	OrderItem oi2= new OrderItem();
//    	oi.setItem(is.get(2));
//    	oi.setQuantity(50);
	
    			
//    	Customer c=new Customer("Abdul",33,"Haryana","Punjab");
//    	ob.addOrderItems(new OrderItem(i3,ob,190));
//    	Set<Orders>orders=new HashSet<Orders>();
//    	ob.setCustomer(c4);
//    	ob.setOrderStatus("Complete");
//    	c.setOrders(orders);
//    	orders.add(ob);
//    	csh.save(c);
//    	oh.save(ob);



//    	Item i=new Item("bat","sports",4,4,8);
//  	i.setOrderItems(new HashSet<OrderItem>("ball","sports",4,4,8));
//    	idao.save(i);
//    	

    	
    	ctx.close();

    }
}
