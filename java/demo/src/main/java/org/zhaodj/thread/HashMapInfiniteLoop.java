package org.zhaodj.thread;

import java.util.HashMap;
import java.util.UUID;

public class HashMapInfiniteLoop {
	
	public static void main(String[] args) throws InterruptedException{
		final HashMap<String, String> map = new HashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        for (int i = 0; i < 1000; i++) {
		            new Thread(new Runnable() {
		                @Override
		                public void run() {
		                	for(int j=0;j<10;j++){
		                		map.put(UUID.randomUUID().toString(), "");
		                	}
		                }
		            }, "ftf" + i).start();
		        }
		    }
		}, "ftf");
		t.start();
		t.join();
	}

}
