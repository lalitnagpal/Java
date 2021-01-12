package com.java.examples.rx.observer;

public class ObserverDesignPattern {
	
	public static void main(String[] args) {
		Book book = new Book("GooseBumps", "Horror", "Xyz", 200, "SoldOut");
		
		EndUser user1 = new EndUser("Bob", book);
		EndUser user2 = new EndUser("Rob", book);
	
		System.out.println("Get in stock > " + book.getInStock());
		
		book.setInStock("In stock");
		
	}

}
