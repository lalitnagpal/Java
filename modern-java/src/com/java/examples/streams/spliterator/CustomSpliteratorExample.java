package com.java.examples.streams.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.java.examples.streams.Book;

public class CustomSpliteratorExample {
	
	public static void main(String[] args) {
		
		Path path = Paths.get("Books.txt");
		try ( Stream<String> lines = Files.lines(path) ) {
			
			Spliterator<String> baseSpliterator = lines.spliterator();
			Spliterator<Book> bookSpliterator = new BookSpliterator(baseSpliterator);
			
			// Set the 2nd argument to true if you want parallel
			Stream stream = StreamSupport.stream(bookSpliterator, false);
			stream.forEach( System.out::println );
			
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
}
