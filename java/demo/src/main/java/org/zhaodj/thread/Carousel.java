package org.zhaodj.thread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 传送带
 * @author zhaodj
 *
 */
public class Carousel {
	
	private Queue<Product> container=new ArrayBlockingQueue<Product>(20);
	private Sensor frontSensor=new Sensor(new CameraHandler(0),new CameraHandler(1));
	private Sensor sideSensor=new Sensor(new CameraHandler(2),new CameraHandler(3));
	
	public void start(){
		frontSensor.start();
		sideSensor.start();
		this.move();
	}
	
	public void move(){
		System.out.println(container.size());
	}

}
