package com.java.examples;

import java.util.function.BiFunction;

public class StaticReferenceExample {

	public static void main(String[] args) {
		
		BiFunction<String, String, String> biFunction = A_Class :: staticMethod;
		
		System.out.println(biFunction.apply("Lalit ", "Nagpal"));

	}
	
}


class A_Class{
	
	static String staticMethod(String a, String b) {
		return a+b;
	}
}
