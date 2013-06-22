package org.zhaodj.util;

import java.util.Random;

public class RandomDemo {
	
	public static void main(String[] args){
		Random rand=new Random();
		for(int i=0;i<100;i++){
			System.out.print(rand.nextInt(10000000)+",");
		}
	}

}
