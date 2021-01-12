package com.java.examples.rx;

public class CallBackDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("This is the main thread running!");
		Thread t = new Thread( () -> new CallBackDemo().runningAsync( () -> System.out.println("CallBack called") ) );
		t.start();
		Thread.sleep(2000);
		System.out.println("Main thread exited!");
	}
	
	public void runningAsync(CallBackIntf callback) {
		System.out.println("I am running asynchronously");
		sleep(1000);
		callback.call();
	}
	
	public void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			System.out.println("Error while sleeping - " + e.getMessage());
			e.printStackTrace();
		}
	}
}
