package spring.test;
 
import java.util.Arrays;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import spring.Tx.Employee;
import spring.Tx.Employee.Gender;
import spring.Tx.EmployeeService;
 
public class TxClient {
 
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("Tx-hibernate-ann.xml");
		EmployeeService es=ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		//long id, String name, int age, float salary, int level, int experience, Gender gender
		es.update(new Employee(10,"Ten",10,1088,10,10,Gender.FEMALE));
		es.getAll().forEach(e->System.out.println(e));
		ctx.close();
 
	}
 
}