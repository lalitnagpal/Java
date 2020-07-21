package com.java.examples;

public class PureImpureFunctions {
   // Only returns the calculation, does not change state internally or outside
   public int sum(int a, int b) {
	      return a + b;
   }
}


class ImpureFunction {
   private int value = 0;
   // Changes the state internally
   public int add(int nextValue) {
      this.value += nextValue;
      return this.value;
   }	
}
