package com.java.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExamples {

	public static void main(String[] args) {
		
		List<String> list = List.of("Kit", "Kat", "Chocolate");
		
//		Function<String, Integer> function =  e -> e.length();
//	    Writing above statement with a method reference ClassName::instanceMethod name 
// 		Note: no parenthesis after method name
		Function<String, Integer> function =  String::length;
		
		List<Integer> newList = map(list, function);
		
		System.out.println(newList);

	}
	
	private static <T,R> List<R> map(List<T> list, Function<T,R> function) {
		List<R> newList = new ArrayList<>();
		for (T a: list) {
			newList.add( function.apply(a) );
		}
		return newList;
	}

}
