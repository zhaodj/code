package org.zhaodj.thread;

public class JoinOrder implements Runnable{

	private int time=100;
	
	public JoinOrder(int time){
		this.time=time;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" stop");
	}
	
	public static void main(String[] args) throws InterruptedException{
		Thread t1=new Thread(new JoinOrder(1000),"t1");
		t1.start();
		//t1.join(); 错误，直接阻塞
		Thread t2=new Thread(new JoinOrder(100),"t2");
		t2.start();
		t2.join();//错误，顺序执行
		t1.join();
		System.out.println("main stop");
	}

}
