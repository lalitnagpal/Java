package com.java.examples.patterns.fluent.interfaces;

public class FluentInterfaces {

	public static void main(String[] args) {
		
				Order.place( order -> order
									.add("shoes")
									.add("Headphones")
									.deliverAt("Street no 45, Jodhpur")
							);
	}

}
