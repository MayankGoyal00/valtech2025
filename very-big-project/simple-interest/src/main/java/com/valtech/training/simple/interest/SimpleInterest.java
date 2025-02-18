package com.valtech.training.simple.interest;
import com.valtech.training.arithmetic.Operation;
public class SimpleInterest {

	public static int compute(int print,int rate, int time) {
		int product=Operation.MULTI.perform(print*rate,time);
		return product/100;
	}
}
