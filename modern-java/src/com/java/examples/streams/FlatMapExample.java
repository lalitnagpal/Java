package com.java.examples.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		
		Stream<String> a = Stream.of("Hello", "Hi");
		Stream<String> b = Stream.of("Learning", "Java");
		
		// Error - A Stream.of will create a Stream<Stream<String>> and wouldn't combine the two streams
		// Stream<String> c = Stream.of(a, b);

		// The below will merge the contents of the two streams into one new Stream called c
		Stream<String> c = Stream.of(a, b).flatMap( x -> x);
		
		c.forEach( System.out::println );
		
		// Reading a file - this file itself
		Path p = Paths.get("D:\\1Workspace\\Java\\modern-java\\src\\com\\java\\examples\\streams\\FlatMapExample.java");

        try(Stream<String> notebook = Files.lines(p);) {
            
            List<String> lines = notebook
						            .flatMap(line -> Arrays.stream(line.split(" ")))
						            .collect(Collectors.toList());
            
            lines.forEach(System.out::println);
            
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

	}
}
