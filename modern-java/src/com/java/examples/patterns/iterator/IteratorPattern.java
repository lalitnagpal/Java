package com.java.examples.patterns.iterator;

import java.util.List;
import java.util.function.Consumer;

public class IteratorPattern {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(List.of("Lalit", "Nagpal").toArray());
		list.forEach( System.out::println );
	}
}

class MyArrayList {	
	Object[] elements;

	public MyArrayList(Object[] elements) {
		this.elements = elements;
	}
	
	public void forEach(Consumer<Object> action) {
		for (int i=0; i<elements.length; i++) {
			action.accept(elements[i]);
		}
	}
}
