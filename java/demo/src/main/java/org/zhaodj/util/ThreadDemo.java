package org.zhaodj.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo implements Runnable{
	
	public static Set<Integer> set=Collections.synchronizedSet(new HashSet<Integer>());
	public static Map<Integer,Integer> map=Collections.synchronizedMap(new HashMap<Integer,Integer>());
	private CountDownLatch cd;
	
	public static void main(String[] args){
		int threadNum=1000;
		CountDownLatch threadSignal = new CountDownLatch(threadNum);
		for(int i=0;i<10;i++){
			map.put(i, 0);
		}
		for(int i=0;i<threadNum;i++){
			Thread t=new Thread(new ThreadDemo(threadSignal));
			t.start();
		}
		try {
			threadSignal.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(map);
		System.out.println(set);
	}
	
	public ThreadDemo(CountDownLatch cd){
		this.cd=cd;
	}
	
	public void run() {
		for(int i=0;i<10;i++){
			while(canPut(i)){
				set.add(i);
				put(i);
				set.remove(i);
				break;
			}
		}
		this.cd.countDown();
	}
	
	private synchronized boolean canPut(int num){
		return !set.contains(num);
	}
	
	private synchronized void put(int num){
		map.put(num, map.get(num)+1);
	}

}
