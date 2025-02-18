package day2;

public class SimpleAirthemet implements Airthmetic {

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public double sub(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double mul(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double div(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
	public static void main(String[] args) {
		SimpleAirthemet n=new SimpleAirthemet();
		System.out.println(n.add(10, 30));
		System.out.println(n.sub(10, 30));
		System.out.println(n.mul(10, 30));
		System.out.println(n.div(10, 30));
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
}


