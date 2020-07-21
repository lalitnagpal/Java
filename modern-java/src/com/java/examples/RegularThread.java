package com.java.examples;

public class RegularThread {
	
	public static void main(String[] args) {
		
		/* Primitive style */
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
	
		/* Anonymous class approach */
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread Executed!");
			}
		});
		t2.start();
	
	
		/* Lambda approach */
		Thread t = new Thread( 
				() -> System.out.println("Thread Executed!")
		);
		t.start();

	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread Executed!");
	}
	
}
