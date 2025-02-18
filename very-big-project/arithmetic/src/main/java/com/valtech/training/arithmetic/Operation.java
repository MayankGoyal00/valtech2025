package com.valtech.training.arithmetic;

public interface Operation {
	
	
	  public static final Operation  ADD = (a, b) -> a + b;
	  public static final Operation SUB = (a, b) -> a - b;
	  public static final Operation MULTI = (a, b) -> a * b;
	  public static final Operation DIV = (a, b) -> a / b;
	   
	   int perform(int a,int b);
	
}
