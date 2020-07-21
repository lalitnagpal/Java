package com.java.examples;

import java.util.function.Function;

public class ConstructorReferenceExamples {

	public static void main(String[] args) {
		
		Function<Runnable, Thread> threadGeneratorLambda = r -> new Thread(r);
		
		// Using constructor reference in place of this Lambda
		Function<Runnable, Thread> threadGeneratorLambdaTwo = Thread::new;
		
		// The below cannot be converted to a method reference, so have to use Lambda
		Runnable task1 = () -> System.out.println("Task 1 executed");
		Runnable task2 = () -> System.out.println("Task 2 executed");
		
		// call the Apply method to pass the Runnable to the Thread 
		// threads won’t start till you call the start method on them
		threadGeneratorLambdaTwo.apply(task1).start();
		threadGeneratorLambdaTwo.apply(task2).start();
		
		// Code looks more functional in the following way
		// Runnable is a functional interface with a abstract method run
		threadGeneratorLambdaTwo
			.apply( () -> System.out.println("Task 3 executed") )
			.start();
		
	}
}
