package org.zhaodj.thread;

import java.util.LinkedList;

public class ProducerAndConsumer {

	private int max = 10;
	private int productId = 0;
	private int count = 0;
	private LinkedList<Integer> store = new LinkedList<Integer>();

	public ProducerAndConsumer(int max) {
		this.max = max;
	}

	public void push() {
		synchronized(store){
			while (count == max) {
				try {
					System.out.println("仓库已满");
					store.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			productId++;
			count++;
			int id = productId;
			store.addFirst(id);
			System.out.println("生产：" + id);
			store.notifyAll();
		}
	}

	public void pop() {
		synchronized (store) {
			while (count == 0) {
				try {
					System.out.println("仓库已空");
					store.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int id = store.removeLast();
			count--;
			System.out.println("消费：" + id);
			store.notifyAll();
		}
	}

	public static class Producer implements Runnable {

		private ProducerAndConsumer storage;

		public Producer(ProducerAndConsumer storage) {
			this.storage = storage;
		}

		@Override
		public void run() {
			for(int i=0;i<100;i++){
				this.storage.push();
				/*try {
					Thread.sleep((int)Math.random()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}

	}

	public static class Consumer implements Runnable {

		private ProducerAndConsumer storage;

		public Consumer(ProducerAndConsumer storage) {
			this.storage = storage;
		}

		@Override
		public void run() {
			for(int i=0;i<100;i++){
				this.storage.pop();
				/*try {
					Thread.sleep((int)Math.random()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}

	}

	public static void main(String[] args) {
		ProducerAndConsumer storage = new ProducerAndConsumer(10);
		Thread producer = new Thread(new Producer(storage));
		Thread consumer = new Thread(new Consumer(storage));
		producer.start();
		consumer.start();
	}

}
