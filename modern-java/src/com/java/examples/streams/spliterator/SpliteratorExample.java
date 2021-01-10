package com.java.examples.streams.spliterator;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorExample {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList();
		list.add(10);
		list.add(12);
		list.add(16);
		list.add(14);
		list.add(11);
		
		Stream<Integer> stream = list.stream();
		Spliterator<Integer> spliterator = stream.spliterator();
		System.out.println("Spliterator characteristics - " + spliterator.characteristics());
		int bits = spliterator.characteristics();
		System.out.println("Spliterator bit count - " + Integer.bitCount(bits));
		
		// OR
		// Picked up from ArrayList.java public static final int ORDERED    = 0x00000010
		// This won't have any affect as the bit is already set
		System.out.println( "Spliterator characteristics - " + ( bits | 0x00000010 ));
		System.out.println( "Spliterator bit count - " + Integer.bitCount( bits | 0x00000010 ) );
		
		// Better way of checking if the characteristics is set or not
		System.out.println(spliterator.hasCharacteristics(Spliterator.SIZED));
	}
}
