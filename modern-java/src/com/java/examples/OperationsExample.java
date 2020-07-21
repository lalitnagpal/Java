package com.java.examples;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OperationsExample {

	public static void main(String[] args) {

		Optional<String> optionalValue = Optional.of("SomeValue");
		
		// map operation - modifies the value from a Optional and returns
		// Outputs - Replaced Value
		Optional<String> mappedValue = optionalValue.map( val -> "Replaced Value" );
		System.out.println(mappedValue.orElse("default value"));

		// Outputs - Replaced Value
		String mappedValueAsString = optionalValue.map( val -> "Replaced Value" ).orElse("default value");
		System.out.println(mappedValueAsString);
		
		// filter operation - checks the condition on a optional using a Predicate
		// Outputs - ABCD
		Optional<String> someValue = Optional.of("ABCD");
		Optional<String> filterValue = someValue.filter( val -> val.equals("ABCD"));
		System.out.println(filterValue.get());
		
		// filter - this leads to a exception as someValue is empty
		// Outputs - java.util.NoSuchElementException: No value present
		try {
			Optional<String> someValue2 = Optional.empty();
			Optional<String> filterValue2 = someValue.filter( val -> val.equals("Replaced Value"));
			System.out.println(filterValue2.get());
		} catch(NoSuchElementException e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		// flatMap operation - similar to map but the returned value would not be mapped to a Optional 
		// as the return value is already a Optional value
		// Outputs - java.util.Optional: Optional[Replaced by FlatMap]
		Optional<String> someValue3 = Optional.of("Lalit");
		Object o = someValue3.flatMap( val -> Optional.of("Replaced by FlatMap") );
		System.out.println(o.getClass().getName() + ": " + o.toString());
		
		// Outputs - java.util.Optional: Optional[Optional[Replaced by FlatMap]]
		Object o2 = someValue3.map( val -> Optional.of("Replaced by FlatMap") );
		System.out.println(o2.getClass().getName() + ": " + o2.toString());
		
		// ifPresent invokes a Consumer action
		Optional valueOne = Optional.of("value");
		valueOne.ifPresent(System.out::println);
		
		// ifPresentOrElse invokes a Consumer action
		Optional valueTwo = Optional.empty();
		valueTwo.ifPresentOrElse(System.out::println, () -> System.out.println("The value is empty!"));
		
		// Stream Example - returns in sequence the values - valueOne has value, valueTwo is empty 
		// Nothing happens in the second and third case
		valueOne.stream().forEach(System.out::println);
		valueTwo.stream().forEach(System.out::println);
		Optional.empty().stream().forEach(System.out::println);
		
		// or - takes a supplier and returns same Optional if it has a value
		// if Optional is empty then it supplies a new Optional specified
		// will print Optional["Some Value"] - doesn't automatically create the Optional wrapper
		System.out.println( valueOne.or( () -> Optional.of("Some Value") ) );
		valueTwo.or( () -> Optional.of("Some Value") ).ifPresent( System.out::println );
		
		// We should take care that the supplier function on the or side is not null else we get a NPE
		// Prints: java.lang.NullPointerException: null
		try {
			System.out.println( valueTwo.or( () -> Optional.of(null) ) );
		} catch (NullPointerException npe) {
			System.out.println(npe.getClass().getName()+": "+npe.getMessage());
		}

		// other object is equals to the Optional or not
		System.out.println( valueOne.equals(Optional.of("value")) );
		
		// hashCode 
		System.out.println( valueOne.hashCode() );
		System.out.println( valueOne.orElseGet( () -> "").hashCode() );
		// 2nd line could have also written as
		System.out.println( valueOne.orElseGet( () -> Optional.empty() ).hashCode() );
		// Returns 0 for a case where Optional is empty
		System.out.println( Optional.empty().hashCode() );
		
		
		
	}

}
