package com.java.examples;

public class MyFunctionalInterfaceThree {

	public static void main(String[] args) {

		onTheFly( () -> System.out.println("Hello") );
	}
	
	public static void onTheFly(FunInterface fi) {
		fi.myMethod();
	}
	
}

@FunctionalInterface
interface FunInterface {
	public void myMethod();
}
