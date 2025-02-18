package day2;

import java.util.Iterator;

public class ControlStatements {
	public void testIfElse(int a) {
		if(a%2==0) {
			System.out.println("even"+a);
		}
		else {
			System.out.println("odd");
		}	
	}
	public void testfor(int [] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		switch (a) {
			case 1:
				System.out.println("one");
				break;
			case 2:
				System.out.println("two");
				break;
			case 3:
				System.out.println("3");
				break;
			default:
				System.out.println("all");
		}
	}
	
	public int add(int iv,int ... a)/**vararch should be last argument**/ {
	
		int sum=iv;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		System.out.println(sum);
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		ControlStatements cs=new ControlStatements();
		cs.testIfElse(3);
		cs.testIfElse(4);
		cs.testIfElse(0);
		cs.testIfElse(-3);
		cs.testfor(new int[] {1,2,3});
		cs.testSwitch(1);
		cs.testSwitch(3);
		cs.testSwitch(34);
		cs.testSwitch(2);
		
		cs.add(1,2);
		cs.add(1,2,3);
		cs.add(1,2,3,4,5,6);
		
	}

}
