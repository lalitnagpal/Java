package com.java.examples.streams.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInActionThree {
	
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
		
			// Count of Designations - Downstream Collectors
			
			Map<String, Long> designationCountMap = employeeList.stream().collect( Collectors.groupingBy( e -> e.getDesignation(), Collectors.counting() ));
			
			designationCountMap.entrySet().forEach( System.out::println );
			
			// Sum of Salary per Designation - Downstream Collectors
			
			Map<String, Double> salarySumByDesignationMap = employeeList.stream().collect( Collectors.groupingBy( e -> e.getDesignation(), Collectors.summingDouble( e -> e.getSalary() )));
			
			salarySumByDesignationMap.entrySet().forEach( System.out::println );
			
			// Max salary per designation
			
			Map<String, Optional<Employee>> maxSalaryMap = employeeList.stream().collect( Collectors.groupingBy( e -> e.getDesignation(), Collectors.maxBy( Comparator.comparing( e -> e.getSalary() ) )));
			
			maxSalaryMap.entrySet().forEach( System.out::println );
			
			// Sum of Salary per Designation - Downstream Collectors - Don't need complete employee object, just salary
			
			Map<String, Optional<Double>> maxSalaries = employeeList.stream()
																	.collect( Collectors.groupingBy( e -> e.getDesignation(), 
																			  Collectors.mapping( e -> e.getSalary(), 
																					   			  Collectors.maxBy( Comparator.comparing( salary -> salary) ) ) ) );
			maxSalaries.entrySet().forEach( System.out::println );
			
			// Sum of Salary per Designation - Downstream Collectors - Don't need complete employee object, just salary - FUNCTION.IDENTITY
			
			Map<String, Optional<Double>> maxSalaries2 = employeeList.stream()
																	.collect( Collectors.groupingBy( e -> e.getDesignation(), 
																			  Collectors.mapping( e -> e.getSalary(), 
																					   			  Collectors.maxBy( Comparator.comparing( Function.identity() ) ) ) ) );
			maxSalaries2.entrySet().forEach( System.out::println );			
			
		} catch (IOException ioEx) { 
			System.out.println(ioEx); 
		}
	}
}
