package com.java.examples.streams;

import java.util.stream.Stream;

public class StreamOfExample {

	public static void main(String[] args) {

		Stream<Integer> numbers = Stream.of(1, 5, 4, 7, 4, 8, 2, 11, 12, 15, 13 );
		
		Stream<Integer> evenNumbers = numbers.filter( num -> num % 2 == 0 );
		
		evenNumbers.forEach( System.out::println );

	}
}
