package com.java.examples;

import java.util.ArrayList;
import java.util.List;

public class UnaryOperatorExample {

	public static void main(String[] args) {
		
		List<Integer> myList = List.of(10, 20, 30);
		
		SomeFunctionalInterface<Integer> function = (i) -> i * 100; 
		
		List<Integer> list2 = map(myList, function);
		
		System.out.println(list2);
		
	}
	
	private static <T> List<T> map(List<T> list, SomeFunctionalInterface<T> function) {
		List<T> countsList = new ArrayList<T>();
		for(T t: list) {
			countsList.add( function.multiplyByHundred(t) );
		}
		return countsList;
	}
}

@FunctionalInterface
interface SomeFunctionalInterface<T> {
	T multiplyByHundred(T t);
}
