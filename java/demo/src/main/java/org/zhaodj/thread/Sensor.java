package org.zhaodj.thread;

/**
 * 传感器
 * @author zhaodj
 *
 */
public class Sensor {
	
	private Product product;
	private Thread handlerFront;
	private Thread handlerSide;
	
	public Sensor(CameraHandler handlerFront,CameraHandler handlerSide){
		this.handlerFront=new Thread(handlerFront);
		this.handlerSide=new Thread(handlerSide);
	}
	
	public void start(){
		this.handlerFront.start();
		this.handlerSide.start();
	}

}
