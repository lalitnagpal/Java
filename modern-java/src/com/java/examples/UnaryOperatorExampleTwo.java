package com.java.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorExampleTwo {

	public static void main(String[] args) {
		
		List<Integer> myList = List.of(10, 20, 30);
		
		UnaryOperator<Integer> function = (i) -> i * 100; 
		
		List<Integer> list2 = map(myList, function);
		
		System.out.println(list2);
		
	}
	
	private static <T> List<T> map(List<T> list, UnaryOperator<T> function) {
		List<T> countsList = new ArrayList<T>();
		for(T t: list) {
			countsList.add( function.apply(t) );
		}
		return countsList;
	}
}

