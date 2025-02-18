package day3;

public class SimpleInterestImpl implements Simpleinterest {

	public static void main(String[] args) {
		Simpleinterest si= new SimpleInterestImpl();
		System.out.println(si.computeinterest(2000,12,3));
		Simpleinterest newSi = new Simpleinterest() {
			@Override
			public double computeinterest(double principal, double rateOfInterest, double duration) {
				// TODO Auto-generated method stub
				return Simpleinterest.super.computeinterest(principal, rateOfInterest, duration);
			}
		};
		System.out.println(newSi.computeinterest(2000,12,3));
	}
	
}
