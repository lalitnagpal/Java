package com.java.examples.patterns.factory;

public class FactoryMethodPattern {

    public static void main(String[] args) {
        
        Flooring floor = FlooringFactory.getFlooring(-1, 18);
        floor.installation();
        
        floor = FlooringFactory.getFlooring(13, 46);
        floor.installation();
    }
}

