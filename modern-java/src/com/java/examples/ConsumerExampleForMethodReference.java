package com.java.examples;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExampleForMethodReference {

	public static void main(String[] args) {

		List<String> myList = List.of("One", "Two", "Three", "Four", "Five", "Six");
		
        // Using the Consumer Functional Interface - takes something and returns nothing
        // We are redefining things here using the lambda
		Consumer<String> consumer = (s) -> System.out.println(s);

		printAllElements(myList, consumer);
		
        // Or the shortened form is, no need to redefine using the Lambda
		// The forEach method already takes a consumer and System.out.println is a Consumer
		// so printAllElements function is not required and even the lambda is not required
		myList.forEach( System.out::println );

	}
	
	private static <T> void printAllElements(List<T> list, Consumer<T> consumer) {
		list.forEach( (c) -> consumer.accept(c));
	}

}
