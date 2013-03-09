package com.zhaodj.test.thread;

import java.util.Arrays;
import java.util.LinkedList;

public class DaemonThread {
	private LinkedList<String[]> queue = new LinkedList<String[]>();
	// private String curkey;
	private Thread worker = new Thread(new Worker());
	private boolean completed=false;

	public DaemonThread() {
		//worker.setDaemon(true);
		worker.start();
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void add(String[] value) {
		synchronized (queue) {
			queue.add(value);
			queue.notify();
		}
	}

	private class Worker implements Runnable {

		@Override
		public void run() {
			synchronized (queue) {
				while (!completed) {
					if (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println(Arrays.toString(queue.removeFirst()));
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		DaemonThread daemon = new DaemonThread();
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
			daemon.add(new String[] { "pattern" + i, "template" + i });
		}
		System.out.println("结束");
		daemon.setCompleted(true);
	}

}
