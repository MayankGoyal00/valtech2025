package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		String s="hello";
		String s1="hello";
		assertSame(s,s1);
		String s2 =new String("hello");
		assertNotSame(s1,s2);
		String s3 ="hell"+"o";
		assertSame(s,s3);
		String s4= "o";
		String s5 ="hell"+s4;
		assertNotSame(s3,s5);
		final String s6 ="o";
		String s7="hell"+s6;
		assertSame(s,s7);
	}

}
