package com.java.examples.rx.observer;

public class EndUser implements Observer {

	String name;
	
	public EndUser(String name, SubjectLibrary subjectLibrary) {
		super();
		this.name = name;
		subjectLibrary.subscribeObserver(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(String available) {
		System.out.println("Hello "+ name + "! we are glad to notify you that your book is now available " + available);
	}

}
