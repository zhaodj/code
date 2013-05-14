package org.zhaodj.thread;

public class YieldDemo implements Runnable{
	
	private String name;
	
	public YieldDemo(String name){
		this.name=name;
	}

	@Override
	public void run() {
		int times=1000000;
		for(int i=0;i<times;i++){
			if(i%10==0){
				Thread.yield();
			}
		}
		System.out.println(this.name);
	}
	
	public static void main(String[] args){
		Thread t1=new Thread(new YieldDemo("1"));
		t1.setPriority(Thread.MIN_PRIORITY);
		Thread t2=new Thread(new YieldDemo("2"));
		t2.setPriority(Thread.NORM_PRIORITY);
		Thread t3=new Thread(new YieldDemo("3"));
		t3.setPriority(Thread.MAX_PRIORITY);
		Thread t4=new Thread(new YieldDemo("4"));
		t4.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
