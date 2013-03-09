package com.zhaodj.test.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Using a ReadWriteLock to implement a cache.
public class CacheDemo {
	private Map<String, Object> cache = new HashMap<String, Object>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		CacheDemo cache = new CacheDemo();
		Object obj = cache.getData("");
		System.out.println(obj.toString());
	}

	// Get the value from DB if the value does not exist,and then return it.
	public Object getData(String key) {
		rwl.readLock().lock();
		Object value = null;
		try {
			value = cache.get(key);
			if (value == null) {
				// Must release read lock before acquiring write lock
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					// Recheck state because another thread might have acquired
					// write lock and changed state before we did.
					if (value == null) {
						// Here may access Database.
						// ...
						value = "Data";
					}
				} finally {
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		} finally {
			rwl.readLock().unlock();
		}
		return value;
	}
}