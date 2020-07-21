package com.java.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class BiFunctionExample {

	public static void main(String[] args) {
	
		/* Using custom BiFunction - not required actually, but just to understand*/
		MyBiFunction<String,String,Integer> myBiFunc = (s1, s2) -> s1.length() + s2.length();
		
		System.out.println( myBiFunc.apply("Lalit", "Nagpal") );
		
		/* Using BiFunction directly now */
		BiFunction<String,Integer,Map> myBiFunc2 = (s1, i1) -> { Map m = new HashMap(); m.put(i1, s1); return m; };
		Map m = myBiFunc2.apply("Lalit Nagpal", 434);
		m.keySet().forEach( (k) -> System.out.print(k + ": " + m.get(k)) );
		
	}
	
}

/* There is no need to write this actually, we can use BiFunction */

@FunctionalInterface
interface MyBiFunction<T,U,R> {
	R apply(T t, U u);
}
