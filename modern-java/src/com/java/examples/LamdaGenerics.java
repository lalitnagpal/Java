package com.java.examples;

public class LamdaGenerics {

	public static void main(String[] args) {
		
		// Parameters are specified as <String, String>
		AFunctionalInterface<String, String> a = (s) -> s.substring(0, 6);
		System.out.println( a.execute("Return just first 5 characters") );

		// Parameters are specified as <String, Integer>
		AFunctionalInterface<String, Integer> a2 = (s) -> s.length();
		System.out.println( a2.execute("Return the length of this") );	
	}
}

@FunctionalInterface
interface AFunctionalInterface<T, R> {
	
	R execute(T t);
}
