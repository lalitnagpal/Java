package com.java.examples.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(1, 5, 4, 7, 4, 8, 2, 11, 12, 15, 13 );
		
		// Filter Method
		
		numbers
			.parallelStream()
			.filter( num -> num % 2 == 0 )
			.forEach( System.out::println );

		// Map Method - converted from List<Integer> to List<Double>
		
		List<Double> doubleList  = numbers
									.parallelStream()
									.map( num -> Double.parseDouble(num.toString()) )
									.collect( Collectors.toList() );
		doubleList.forEach(System.out::println);
		
		// Reduce Method - Sum of all numbers
		
		Integer sum  = numbers
				.parallelStream()
				.reduce(0, (a,b) -> a + b );
		
		System.out.println( "Sum of all numbers is: " + sum );
		
		// Streams are Lazy. peek() method
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));
		
		Stream<Book> popularHorrorBooks = books.stream()
											.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
											.peek( book -> System.out.println("Filtering for book " + book))
											.filter((book) -> book.getRating() > 3); 
											// .collect(Collectors.toList());		
		collect( popularHorrorBooks );
		
		// Calculating the Average
		
		OptionalDouble average = books.stream()
							       .map( book -> book.getRating() )
							       // since average works on Numeric streams only - so mapToDouble called
							       .mapToDouble( rating -> rating )				
							       .average();

		System.out.println("The average is: " + average.getAsDouble());

		
	}
	
	private static void collect(Stream<Book> books) {
		System.out.println("Collecting now");
		books.forEach( System.out::println );
	}
}
