package com.java.examples;

public class LambdaTakesNothingReturnsNothing {

	public static void main(String[] args) {
		
		MyName name = () -> System.out.println("My Name is Lalit");
		// Invoke it now
		name.showName();
	}
	
}

@FunctionalInterface
interface MyName {
	public void showName(); 
}
