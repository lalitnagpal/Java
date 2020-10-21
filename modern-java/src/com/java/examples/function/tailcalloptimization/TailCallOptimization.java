package com.java.examples.function.tailcalloptimization;

public class TailCallOptimization {
	
	public static void main(String[] args) {
	}
	
	
	public static long reFact(int n) {
		if( n  <= 1)
			return 1;
		else
			return n * reFact(n-1);
	}
	
	
	// Arguments - n is number whose factorial needs to be calculated
	// a is the accumulator to accumulate the product
	public static long tailReFact(int n, int a) {
		
		if( n <= 1)
			return a;
		else
			return tailReFact(n-1, n * a);
	}

}
