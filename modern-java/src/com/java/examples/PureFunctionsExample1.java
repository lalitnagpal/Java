package com.java.examples;

public class PureFunctionsExample1 {

	public static void main(String[] args) {
		int result = add(multiply(2,3), multiply(3,4));
		System.out.println("The result is: "+ result);
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int multiply(int a, int b) {
		log(String.format("Returning %s as the result of %s * %s", a * b, a, b));
		return a * b;
	}
	
	public static void log(String m) {
		System.out.println(m);
	}
	
}
