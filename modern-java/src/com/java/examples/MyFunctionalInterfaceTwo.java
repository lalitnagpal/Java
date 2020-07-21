package com.java.examples;

public class MyFunctionalInterfaceTwo {

	public static void main(String[] args) {
		
		// A Implementation assignment to a function 
		MyFunInterface mf = () -> System.out.println("Hello there!");

		// Just like we do for a variable
		Integer x = 100;

		// And to invoke it now, call the only abstract method it has
		mf.myMethod();
	
	} 
	
}

@FunctionalInterface
interface MyFunInterface {
	public void myMethod();
}
