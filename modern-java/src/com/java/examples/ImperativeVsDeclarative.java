package com.java.examples;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {

	public static void main(String[] args) {
		
		// Imperative style of programming
		int sumOfEvens = 0;
		for (int i=0; i<=100; i++) {
			if (i % 2 == 0)
			   sumOfEvens += i;
		}
		System.out.println("Sum of all evens is ->" + sumOfEvens);
		
		// Declarative or Functional style of programming
		sumOfEvens = IntStream.rangeClosed(0, 100)
		.filter( i -> i%2 == 0)
		.reduce( (x,y) -> x + y)
		.getAsInt();
				
		System.out.println("Sum of all evens is ->" + sumOfEvens);
	}
}
