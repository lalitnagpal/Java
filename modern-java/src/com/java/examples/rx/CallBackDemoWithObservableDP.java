package com.java.examples.rx;

public class CallBackDemoWithObservableDP {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("This is the main thread running!");
		Thread t = new Thread( () -> { new CallBackDemoWithObservableDP().runningAsync( new CallBack() {
											@Override
											public void pushData(String data) {
												System.out.println("Received data: " + data);
											}

											@Override
											public void pushComplete() {
												System.out.println("Push completed!");
											}

											@Override
											public void pushError(Exception ex) {
												System.out.println("Callback Error called, got an Exception " + ex.getMessage());
											}
										} ); 
									}
							 );
		t.start();
		Thread.sleep(2000);
		System.out.println("Main thread exited!");
	}
	
	public void runningAsync(CallBack callback) {
		
		System.out.println("I am running asynchronously");
		sleep(1000);
		// Pushing data to the thread
		callback.pushData("Data 1");
		callback.pushData("Data 2");
		callback.pushData("Data 3");
		
		// Push the error now
		callback.pushError(new RuntimeException("Oops"));
		
		callback.pushComplete();
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
