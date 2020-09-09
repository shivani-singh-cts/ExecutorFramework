package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//A Task which would return a value
class CallableTask implements Callable<String>{

	private String name;
	public CallableTask(String name) {
		this.name = name;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello " + name;
	}
}

public class CallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		//Callable will return value after some time so we need to store the value in Future.
		Future<String> welcomeFuture = executorService.submit(new CallableTask("Shivani"));
		System.out.println("new Callable executed");
		String welcomeMessage = welcomeFuture.get();
		
		System.out.println(welcomeMessage);
		System.out.println("Main Completed");
		executorService.shutdown();
	}

}
