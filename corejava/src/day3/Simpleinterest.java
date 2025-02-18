package day3;

public interface Simpleinterest {
	
	default double computeinterest(double principal, double rateOfInterest, double duration) {
		return principal* rateOfInterest * duration/100;
	}

}
