package org.zhaodj.thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockProducerAndConsumer {

	private Lock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	private LinkedList<Integer> store = new LinkedList<Integer>();
	private int max = 10;
	private int count = 0;
	private int productId = 0;
	private Thread producer,consumer;
	
	public LockProducerAndConsumer(int max){
		this.max=max;
		producer=new Thread(new Producer());
		consumer=new Thread(new Consumer());
	}
	
	public void start(){
		producer.start();
		consumer.start();
	}

	public void push(int id) {
		lock.lock();
		try {
			while (count == max) {
				System.out.println("仓库已满");
				try {
					notFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			store.addFirst(id);
			System.out.println("生产：" + id);
			count++;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public int pop() {
		lock.lock();
		try {
			while (count == 0) {
				System.out.println("仓库已空");
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int id = store.removeLast();
			System.out.println("消费：" + id);
			count--;
			notFull.signal();
			return id;
		} finally {
			lock.unlock();
		}
	}
	
	class Producer implements Runnable{

		@Override
		public void run() {
			for(int i=0;i<100;i++){
				push(++productId);
			}
		}
		
	}
	
	class Consumer implements Runnable{

		@Override
		public void run() {
			for(int i=0;i<100;i++){
				pop();
			}
		}
		
	}
	
	public static void main(String[] args){
		new LockProducerAndConsumer(5).start();
	}

}
