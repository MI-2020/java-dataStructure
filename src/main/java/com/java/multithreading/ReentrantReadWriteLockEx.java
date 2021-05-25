package com.java.multithreading;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class CacheAPIImpl {

	ReentrantReadWriteLock readWritelock = new ReentrantReadWriteLock();
	ReadLock readLock = readWritelock.readLock();
	WriteLock writeLock = readWritelock.writeLock();

	HashMap<String, String> map = new HashMap<>();

	public String readCache(String key) {

		readLock.lock();
		System.out.println("fetch::::");
		try {
			Thread.sleep(1000);

			return map.get(key);
		} catch (Exception e) {

		} finally {
			readLock.unlock();
		}
		return null;

	}

	public void writeCache(String key, String value) {
		writeLock.lock();

		try {
			Thread.sleep(4000);
			map.put(key, value);
			System.out.println("added::::");
		} catch (Exception e) {

		} finally {
			writeLock.unlock();
		}
	}

}

public class ReentrantReadWriteLockEx {
	
	

public static void main(String[] args) {
	
	ExecutorService  exService =  Executors.newFixedThreadPool(10);
	
	CacheAPIImpl api = new CacheAPIImpl();
	exService.submit(()-> api.writeCache("10","10"));
	exService.submit(()-> System.out.println(api.readCache("10")));
	exService.submit(()-> api.writeCache("20","20"));
	exService.submit(()-> api.writeCache("30","30"));
	exService.submit(()-> api.writeCache("40","40"));
	
	
	exService.submit(()-> System.out.println(api.readCache("20")));
	exService.submit(()-> System.out.println(api.readCache("10")));
	exService.submit(()-> System.out.println(api.readCache("30")));
	exService.submit(()-> System.out.println(api.readCache("40")));
	exService.submit(()-> System.out.println(api.readCache("50")));
	exService.submit(()-> System.out.println(api.readCache("10")));
	exService.submit(()-> System.out.println(api.readCache("20")));
	exService.submit(()-> System.out.println(api.readCache("30")));
	exService.submit(()-> System.out.println(api.readCache("40")));
	exService.submit(()-> System.out.println(api.readCache("20")));
	exService.submit(()-> System.out.println(api.readCache("30")));
	exService.submit(()-> System.out.println(api.readCache("40")));
	exService.submit(()-> System.out.println(api.readCache("10")));
	
	
}
}
