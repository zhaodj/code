package org.zhaodj.thread;

import java.util.concurrent.CountDownLatch;

public class VolatileDemo {
	
	private volatile boolean stop=false;
	private boolean synstop=false;
	
	
	public void stop(){
		this.stop=true;
	}
	
	public void doWork(){
		int i=0;
		if(!stop&&i<10){
			try {
				i++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(Thread.currentThread().getName());
	}
	
	public synchronized void synStop(){
		this.synstop=true;
	}
	
	public synchronized void synDoWork(){
		int i=0;
		if(!synstop&&i<10){
			try {
				i++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(Thread.currentThread().getName());
	}
	
	public static class Worker implements Runnable{
		
		private VolatileDemo demo;
		private boolean syn=false;
		private CountDownLatch threadsSignal;
		
		public Worker(VolatileDemo demo,boolean syn,CountDownLatch threadsSignal){
			this.demo=demo;
			this.syn=syn;
			this.threadsSignal=threadsSignal;
		}

		@Override
		public void run() {
			if(syn){
				this.demo.synDoWork();
			}else{
				this.demo.doWork();
			}
			this.threadsSignal.countDown();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		VolatileDemo demo=new VolatileDemo();
		int threadNum=100;
		CountDownLatch threadSignal = new CountDownLatch(threadNum);
		Worker worker=new Worker(demo,false,threadSignal);
		Thread[] ts=new Thread[threadNum];
		long start=System.nanoTime();
		for(int i=0;i<ts.length;i++){
			ts[i]=new Thread(worker);
			ts[i].start();
		}
		threadSignal.await();
		//demo.stop();
		System.out.println(System.nanoTime()-start);
		threadSignal = new CountDownLatch(threadNum);
		Worker worker1=new Worker(demo,true,threadSignal);
		start=System.nanoTime();
		for(int i=0;i<ts.length;i++){
			ts[i]=new Thread(worker1);
			ts[i].start();
		}
		threadSignal.await();
		//demo.synStop();
		System.out.println(System.nanoTime()-start);
	}

}
