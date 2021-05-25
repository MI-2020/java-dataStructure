package com.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Task3 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		return "I am in!";
	}
	
}

public class CallableEx {

	public static void main(String[] args) {

		ExecutorService exeService = Executors.newFixedThreadPool(1);

		Future<String> future = exeService.submit(new Task3());

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
}
