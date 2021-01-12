package com.java.examples.rx.observer;

import java.util.ArrayList;

public class Book implements SubjectLibrary {
	
	private String name;
	private String type;
	private String author;
	private double price;
	private String inStock;
	private ArrayList<Observer> observerList = new ArrayList<Observer>();
	
	public Book(String name, String type, String author, double price, String inStock ) {
		super();
		this.name = name;
		this.type = type;
		this.author = author;
		this.price = price;
		this.inStock = inStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
		System.out.println("Availability changed from " + getInStock() + " to " + inStock);
		notifyObserver();
	}

	public ArrayList<Observer> getObserverList() {
		return observerList;
	}

	public void setObserverList(ArrayList<Observer> observerList) {
		this.observerList = observerList;
	}

	@Override
	public void subscribeObserver(Observer observer) {
		
		observerList.add(observer);
	}

	@Override
	public void unsubscribeObserver(Observer observer) {
		
		observerList.remove(observer);
	}

	@Override
	public void notifyObserver() {
		
		System.out.println(
					"Book Name: " + this.name +
					" price: " + this.price +
					" type: " + this.type +
					" author: " + this.author +
					" instock: " + this.inStock
				);
		for (Observer o: observerList) {
			o.update(this.inStock);
		}
	}

}
