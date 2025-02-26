package hibernate.client;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

import hibernate.Account;
import hibernate.Address;
import hibernate.AtmTx;
import hibernate.Car;
import hibernate.CheckTx;
import hibernate.Customer;
import hibernate.Student;
import hibernate.StudentAddress;
import hibernate.StudentId;
import hibernate.TellerTx;
import hibernate.Tx;

public class HibernateClient {
	public static void main(String[] args) {
		SessionFactory sesFac=new AnnotationConfiguration().addAnnotatedClass(Car.class)
				.addAnnotatedClass(Tx.class)
				.addAnnotatedClass(CheckTx.class)
				.addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session ses=sesFac.openSession();
		Transaction tx=ses.beginTransaction();
		

        ses.createQuery
		("SELECT t.amount FROM Tx t JOIN t.account.customers c WHERE c.age < ?")
		.setInteger(0,30)
		.list().stream().forEach(t->System.out.println(t));
        
//        ses.createQuery("SELECT t.account.id, t.amount FROM Tx t JOIN t.account.customers c WHERE c.age<?")
//		.setInteger(0,25)
//		.list().stream().forEach(t->System.out.println(Arrays.deepToString((Object[]) t)));
//        
        
        tx.commit();
		ses.close();   
		sesFac.close(); 
	}
}







