package com.java.examples.patterns.decorator;

import com.java.examples.patterns.decorator.domain.Burger;
import com.java.examples.patterns.decorator.domain.BurgerShop;

public class DecoratorPattern {
	
	public static void main(String[] args) {
		
//        Burger myFirstOrder = new BurgerShop( burger -> burger.addVeggies() ).use( new Burger() );
        
        Burger mySecondOrder = new BurgerShop( burger -> burger.addCheese())
                                         .use( new BurgerShop( burger -> burger.addVeggies() )
                                                        .use( new Burger() )
                        );
        
//        System.out.println("My First Order " + myFirstOrder);
        System.out.println("My Second Order " + mySecondOrder);

	}
}
