package com.zhaodj.test.thread;

public class ThreadLocalDemo implements Runnable{
	
	private static final ThreadLocal<Integer> counter=new ThreadLocal<Integer>();
	
	public static Integer getCounter(){
		Integer c=counter.get();
		if(c==null){
			c=0;
			counter.set(c);
		}
		return c;
	}
	
	public static void increase(){
		counter.set(getCounter()+1);
	}
	
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			increase();
			System.out.println("线程:"+Thread.currentThread().getName()+",counter:"+getCounter());
		}
	}
	
	public static void main(String[] args){
		for(int i=0;i<5;i++){
			Thread thread=new Thread(new ThreadLocalDemo());
			thread.start();
		}
	}

}
