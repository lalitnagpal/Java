package com.java.examples.higherorderfunctions.factory;

public interface IConfigurator<T,R> {
	
	R configure(T t);

}
