package com.java.examples.streams.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInActionTwo {
	
	public static void main(String[] args) {
		
		Path path = Paths.get("EmployeeData.txt");
		
		try ( Stream<String> lines = Files.lines(path) ) {
			
			// Need a custom spliterator to get Stream of Employees 
			// instead of Stream of lines that the above code returns
			
			Stream<String> words = lines.flatMap( line -> Arrays.stream( line.split(",") ) );
			
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

			Set<Employee> employeesSortedSet = employeeList.stream().collect( Collectors.toCollection( TreeSet::new ) );
			
			employeesSortedSet.forEach( System.out::println );
			
			// CONVERTING LIST TO LINKEDLIST
			
			LinkedList myLinkedList = employeeList.stream().collect( Collectors.toCollection( LinkedList::new ) );
			
			// CONVERTING TO A MAP
			
			Map<Integer, String> kvMap = employeeList.stream().collect( Collectors.toMap( e -> e.getId(), e -> e.getName() ));
			
			kvMap.entrySet().forEach( es -> System.out.println("Employee Id: " + es.getKey() + " Name: " + es.getValue() ) );
			
			// PARTITIONING BY GENDER
			
			Map<Boolean, List<Employee>> resultMap = employeeList.stream().collect( Collectors.partitioningBy( e -> e.getGender() == 'M'));
			
			System.out.println("Males");
			resultMap.get(true).stream().forEach( System.out::println );
			
			System.out.println("Females");
			resultMap.get(false).stream().forEach( System.out::println );
			
			// GROUP BY DESIGNATION
			
			Map<String, List<Employee>> groupedEmployees = employeeList.stream().collect( Collectors.groupingBy( e -> e.getDesignation() ) );
			
			groupedEmployees.entrySet().forEach( System.out::println );
			
			// Comma separated Names only
			
			String allNames = employeeList.stream().map(e -> e.getName()).collect( Collectors.joining(", ") );
			
			System.out.println("Names only and separated by comma: " + allNames);
			
			
		} catch(IOException ioEx) {
			System.out.println(ioEx.getMessage());
		}
	}
}
