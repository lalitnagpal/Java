package com.java.examples.rx;

public interface CallBack {

	void pushData(String data);
	void pushComplete();
	void pushError(Exception ex);
}
