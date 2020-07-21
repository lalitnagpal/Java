package com.java.examples;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

	public static void main(String[] args) {
		
		BinaryOperator<String> bOper = (s1, s2) -> s1 + s2;
		System.out.println( bOper.apply("Lalit ", "Nagpal") );
		
		MyBinaryOperator<String> myBinOper = (s1, s2) -> s1 + s2;
		System.out.println( myBinOper.apply("Lalit ", "Nagpal") );
	}
}

@FunctionalInterface
interface MyBinaryOperator<T> {
   T apply(T t, T t1);
}

