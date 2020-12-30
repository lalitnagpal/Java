package com.java.examples.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Parallelism {

	public static void main(String[] args) {
		
		System.out.println("Number of processors -> "+Runtime.getRuntime().availableProcessors());
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
		System.out.println("ForkJoinPool.getCommonPoolParallelism() -> "+ForkJoinPool.getCommonPoolParallelism());
		
		ForkJoinPool pool = new ForkJoinPool(3);
		
		List<Employee> list = new ArrayList<>();
		
		for (int i = 0; i < 1000; i++) {
			list.add(new Employee("John", 20000));
			list.add(new Employee("Rohn", 3000));
			list.add(new Employee("Tom", 15000));
			list.add(new Employee("Bheem", 8000));
			list.add(new Employee("Shiva", 200));
			list.add(new Employee("Krishna", 50000));
		} 
		
		try {
			long count = pool.submit( () -> 
								list.parallelStream()
									.filter( e -> e.getSalary() > 1000)
									.count()
						).get();
			System.out.println("Count is -> " + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
