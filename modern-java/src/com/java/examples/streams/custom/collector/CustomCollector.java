package com.java.examples.streams.custom.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {
	
	public static void main(String[] args) {
	
		List<Integer> numbers = List.of( 2, 4, 3, 5, 9, 7, 8, 6, 13, 12, 11, 17, 15, 16, 21, 19, 18 );
		
		Collector<Integer, List<Integer>, List<Integer>> toList = 
				Collector.of( ArrayList::new,						// Supplier
										 (list, e) -> list.add(e),	// Accumulator which is a BiConsumer
										 (list1, list2) -> {
											 list1.addAll(list2);	// BiFunction - adds up partial results from different threads
											 return list1;
										 },							
										 Collector.Characteristics.IDENTITY_FINISH			
									   );
		
		List<Integer> evens = numbers.stream()
									.filter( e -> e % 2 == 0 )
									.collect( toList );
		
		System.out.println("List: " + evens);

		evens.forEach(System.out::println);
		
		Collector<Integer, List<Integer>, List<Integer>> toSortedList = 
				Collector.of( ArrayList::new,				// Supplier
							  (list, e) -> list.add(e),		// Accumulator which is a BiConsumer
							  (list1, list2) -> {
								  list1.addAll(list2);		// BiFunction - adds up partial results from different threads
								  return list1;
							  },							
							  list -> { Collections.sort(list); return list; },
							  Collector.Characteristics.UNORDERED
			   );		
		
		List<Integer> sortedEvens = numbers.stream()
											.filter( e -> e % 2 == 0 )
											.collect( toSortedList );

		System.out.println("List: " + sortedEvens);
		
		sortedEvens.forEach(System.out::println);

	}
}
