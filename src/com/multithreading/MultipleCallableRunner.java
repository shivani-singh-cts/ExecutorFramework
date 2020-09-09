package com.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<CallableTask> tasks = List.of(new CallableTask("Night Fury"), 
				new CallableTask("Stormcutter"), new CallableTask("Light Fury"));
		
		//List<Future<String>> results = executorService.invokeAll(tasks);
		String result = executorService.invokeAny(tasks);
		System.out.println(result);
		
		/*for(Future<String> result: results)
			System.out.println(result.get());
		*/
		executorService.shutdown();
	}

}
