package com.java.program;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 
 */

class LoggerAPI{
	
	static String filePath;
	
	//factory
	
	ExecutorService exService = Executors.newFixedThreadPool(1);
	
	
	public void logInfo(String inputString) {
		
		
		exService.submit(new Task(inputString,filePath));
	}
	
	
	class Task implements Runnable{
		
		String task;
		String fileName;
		
		Task(String task, String fileName){
			this.task=task;
			this.fileName= fileName;
			
		}

		@Override
		public void run() {

			// write logic in file
			System.out.println(Thread.currentThread().getName()+ task);
		}
	}
	
}


public class LoggerAPIImpl { 
	
	public static void main(String[] args) throws InterruptedException {

		
		for(int i =0 ; i < 100; i++) {
		new LoggerAPI().logInfo("ashish"+i);
		}
		
	
	}
}
