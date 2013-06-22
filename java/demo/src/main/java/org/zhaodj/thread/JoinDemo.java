package org.zhaodj.thread;

public class JoinDemo implements Runnable{

	private Thread pre;
	
	public JoinDemo(){
		
	}
	
	public JoinDemo(Thread pre){
		this.pre=pre;
	}
	
	@Override
	public void run() {
		try {
			if(pre!=null){
				pre.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args){
		int len=20;
		Thread[] arr=new Thread[len];
		arr[0]=new Thread(new JoinDemo(),"0");
		for(int i=1;i<len;i++){
			arr[i]=new Thread(new JoinDemo(arr[i-1]),String.valueOf(i));
		}
		Thread free=new Thread(new JoinDemo(),"I'm free");
		for(int j=0;j<arr.length;j++){
			arr[j].start();
		}
		free.start();
	}

}
