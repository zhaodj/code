package org.zhaodj.thread;

public class WaitNotifyDemo implements Runnable{

	private int total=0;
	
	@Override
	public void run() {
		sum();
	}
	
	
	private synchronized void sum(){
		for(int i=0;i<200;i++){
			total+=i;
		}
		this.notifyAll();
	}
	
	public int getTotal(){
		return this.total;
	}
	
	public static void main(String[] args) throws InterruptedException{
		WaitNotifyDemo demo=new WaitNotifyDemo();
		Thread t=new Thread(demo);
		Reader r=new Reader(demo);
		Thread[] readers=new Thread[5];
		for(int i=0;i<readers.length;i++){
			readers[i]=new Thread(r);
			readers[i].start();
		}
		t.start();
	}
	
	public static class Reader implements Runnable{

		private WaitNotifyDemo demo;
		public Reader(WaitNotifyDemo demo){
			this.demo=demo;
		}
		
		@Override
		public void run() {
			synchronized(this.demo){
				System.out.println("等待:"+demo.getTotal());
				try {
					demo.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("结果"+this.demo.getTotal());
		}
		
	}

}
