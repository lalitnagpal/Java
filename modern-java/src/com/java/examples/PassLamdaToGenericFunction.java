package com.java.examples;

import java.util.ArrayList;
import java.util.List;

public class PassLamdaToGenericFunction {

	public static void main(String[] args) {
		
		List<String> list = List.of("kit", "kat", "story");
		
		AnotherFunctionalInterface<String, Integer> afi = (s) -> s.length();
		
		// We will pass this lambda to a generic method now
		List<Integer> newList = map(list, afi);
		
		System.out.println(newList);

	}
	
    // A generic interface that accepts a list of type T and a function of type T,R
    // it returns a List<R> 
	private static <T,R> List<R> map(List<T> list, AnotherFunctionalInterface<T,R> function) {
		List<R> newList = new ArrayList<>();
		for (T t : list) {
			newList.add( function.execute(t) );
		}
		return newList;
	}
}


@FunctionalInterface
interface AnotherFunctionalInterface<T, R> {
	
	R execute(T t);
}
