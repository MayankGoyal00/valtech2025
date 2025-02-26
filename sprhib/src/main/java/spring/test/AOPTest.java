package spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.tomcat.util.bcel.classfile.ClassParser;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.Arithmetic;

class AOPTest {

	@Test
	void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		Arithmetic arith =(Arithmetic) ctx.getBean("arith");
		System.out.println(arith.getClass().getName());
		System.out.println(arith.add(2, 3));
		System.out.println(arith.sub(2, 3));
		System.out.println(arith.add(-3, -3));
		System.out.println(arith.div(3, 1));
		ctx.close();
	}

}
