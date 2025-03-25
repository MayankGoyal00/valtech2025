package com.valtech.training.Zeroo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
 
        ApplicationContext context= new ClassPathXmlApplicationContext("Spring.xml");
       	Alien ob= (Alien)context.getBean("alien1");
//       	ob.code();
//        Laptop ob2=(Laptop)context.getBean("laptop2");

    }
}
