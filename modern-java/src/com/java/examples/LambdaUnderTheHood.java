package com.java.examples;

public class LambdaUnderTheHood {

	public static void main(String[] args) {
		
		// Anonymous Inner classes approach would lead to two classes getting generated out of the 
		// two implementations shown below - leading to jars becoming bulky and problems in code 
		// shipping
//		MyFunctionalInterface mf = new MyFunctionalInterface() {
//			@Override
//			public void myMethod() {
//				System.out.println("Implementation 1");
//			}
//		};
//
//		MyFunctionalInterface mf2 = new MyFunctionalInterface() {
//			@Override
//			public void myMethod() {
//				System.out.println("Implementation 2");
//			}
//		};
		
		// Lambda approach now - a lightweight approach
		MyFunctionalInterface mf1 = () -> System.out.println("Hello 1");
		mf1.myMethod();
		MyFunctionalInterface mf2 = () -> System.out.println("Hello 2");
		mf2.myMethod();
		
	}
}
