package com.zhaodj.test.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class SetUpdate implements Runnable {

	public static Set<Integer> set = Collections.synchronizedSet(new HashSet<Integer>());
	private CountDownLatch cd;

	public static void main(String[] args) throws InterruptedException {
		int threadNum = 100;
		CountDownLatch threadSignal = new CountDownLatch(threadNum);
		for (int i = 0; i < threadNum; i++) {
			Thread t = new Thread(new SetUpdate(threadSignal));
			t.start();
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (!set.isEmpty()) {
					synchronized (set) {
						Iterator<Integer> iter = set.iterator();
						while (iter.hasNext()) {
							iter.remove();
						}
					}
				}

			}
		}).start();
		threadSignal.await();
		System.out.println(set);
	}

	public SetUpdate(CountDownLatch cd) {
		this.cd = cd;
	}

	@Override
	public void run() {
		synchronized(set){
		for (int i = 0; i < 10000; i++) {
				set.add(i);
		}
		}
		this.cd.countDown();
	}

}
