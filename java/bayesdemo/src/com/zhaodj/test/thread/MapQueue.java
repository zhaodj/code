package com.zhaodj.test.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MapQueue implements Runnable{
	
	public static Map<Integer,Queue<Integer>> map=new HashMap<Integer,Queue<Integer>>();
	
	public static void main(String[] args){
		int n=10;
		for(int i=0;i<n;i++){
			new Thread(new MapQueue()).start();
		}
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			int key=(int)(Math.random()*10);
			getQueue(key).offer(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getQueue(key).poll());
		}
	}
	
	public static Queue<Integer> getQueue(int key){
		synchronized (map) {
			if(map.containsKey(key)){
				return map.get(key);
			}else{
				Queue<Integer> queue=new ConcurrentLinkedQueue<Integer>();
				map.put(key, queue);
				return queue;
			}
		}
	}
	

}
