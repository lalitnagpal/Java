package com.java.examples;

import java.util.stream.IntStream;

public class LambdaTakesParametersReturnsValue {

	public static void main(String[] args) {

		StringOperations so = (a) -> a.length();
		System.out.println(so.length("Calculate the length of this"));

	}
	
}

interface StringOperations {
	int length(String x);
}
