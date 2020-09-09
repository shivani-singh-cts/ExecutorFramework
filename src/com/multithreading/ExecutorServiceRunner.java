package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task extends Thread{
	
	private int number;
	public Task(int number) {
		this.number = number;
	}
	public void run() {
		System.out.println("Task " + number + " Started");
		for(int i =number*100; i<number*100 +99; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("Task " +number +" Completed");
	}
}

public class ExecutorServiceRunner {

	public static void main(String[] args) {
		//new SingleThreadExecutor - only 1 thread will run at a point of time. 
		//Task2 will start only when Task1 is completed.
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//For customizing number of threads
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new Task(1));
		executorService.execute(new Task(2));
		executorService.execute(new Task(3));
		executorService.execute(new Task(4));
		
		executorService.shutdown();
	}

}
