package com.java.examples;

import java.util.function.Supplier;

public class SupplierExampleForMethodReference {

	public static void main(String[] args) {

		Supplier<String> supplier = () -> new String("A String");
		System.out.println(supplier.get());
		
//		Supplier<String> supplierTwo = String::new;
//		System.out.println(supplierTwo.appget());
		
		Supplier<Double> randomNumber = () -> Math.random();
		System.out.println(randomNumber.get());
		
		Supplier<Double> randomNumberTwo = Math::random;

	}

}
