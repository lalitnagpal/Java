package com.java.examples.streams.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInAction {
	
	public static void main(String[] args) {
		
		Path path = Paths.get("EmployeeData.txt");
		
		try (Stream<String> lines = Files.lines(path) ) {
			
			// Need a custom spliterator to get Stream of Employees 
			// instead of Stream of lines that the above code returns
			
			Stream<String> words = lines.flatMap( line -> Arrays.stream(line.split(",")));
			
		    // line.split(",") – will return String[]
		    // Arrays.stream( ... ) – will convert from Array to Stream<String>
		    // lines.map would have returned Stream<Stream<String>>
		    // lines.flatMap would return Stream<String>

			// Base Spliterator that gives Strings
			Spliterator<String> baseWordSpliterator = words.spliterator();
			
			Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(baseWordSpliterator);
			
			Stream<Employee> employeeStream = StreamSupport.stream(employeeSpliterator, false);
			
		    // Created for reuse – now we can do employeeList.stream().map(...) and get a new stream
		    // for each operation we want to try and without getting a stream already used error
		    // since we use new stream now each time we invoke employeeList.stream()

			List<Employee> employeeList = employeeStream.collect( Collectors.toList() );
			
			// Stream can be traversed only once so commenting this line
			// so that the forEach line below can traverse through stream
			// employeeStream.forEach( System.out::println );
			
			Stream<String> employeeNames = employeeList.stream().map( e -> e.getName() );
			
			List<String> empNames = employeeList.stream().map( e -> e.getName() ).collect( Collectors.toList() );
			
			List<String> empUnmodifiableNamesList = employeeList.stream().map( e -> e.getName() ).collect( Collectors.toUnmodifiableList() );
			
			Set<String> empUnmodifiableNamesSet = employeeList.stream().map( e -> e.getName() ).collect( Collectors.toUnmodifiableSet() );
			
			employeeNames.forEach( System.out::println );
			
			// Designations - but duplicated
			
			System.out.println("\r\nDesignations - Duplicates here because of List");
			
			List<String> duplicateDesignationsList = employeeList.stream().map( e -> e.getDesignation() ).collect( Collectors.toList() );
			
			duplicateDesignationsList.forEach( System.out::println );
			
			// Designations - Unique because of Set
			
			System.out.println("Unique Designations");
			
			Set<String> uniqueDesignationsSet = employeeList.stream().map( e -> e.getDesignation() ).collect( Collectors.toSet() );
			
			uniqueDesignationsSet.forEach( System.out::println );
			
		} catch(IOException ioEx) {
			System.out.println(ioEx.getMessage());
		}
	}
}
