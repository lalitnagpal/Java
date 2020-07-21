package com.java.examples;

public class LambdaTakesParamReturnsNothing {
	public static void main(String[] args) {
		MyMaths addOperation = (a, b) -> System.out.println(a + b);
		addOperation.operation(10, 12);
		
		MyMaths multiplyOperation = (a, b) -> System.out.println(a * b);
		multiplyOperation.operation(10, 12);
	}
}

@FunctionalInterface
interface MyMaths {
	public void operation(int a, int b);
}
