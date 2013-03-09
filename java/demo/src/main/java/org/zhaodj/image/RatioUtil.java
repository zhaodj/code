package org.zhaodj.image;

import java.util.Arrays;

public class RatioUtil {
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(calculateMinSize(100,100,290,150)));
		System.out.println(Arrays.toString(calculateMinSize(100,120,200,210)));
		System.out.println(Arrays.toString(calculateMinSize(120,100,210,200)));
		System.out.println(Arrays.toString(calculateMinSize(80,100,290,150)));
	}
	
	public static int[] calculateMinSize(int minWidth,int minHeight,int width,int height){
		double ratio=(double)width/height;
		double minRatio=(double)minWidth/minHeight;
		int[] result=new int[2];
		if(ratio>minRatio){
			result[1]=minHeight;
			result[0]=(int) Math.ceil(minHeight*ratio);
		}
		else{
			result[0]=minWidth;
			result[1]=(int) Math.ceil(minWidth/ratio);
		}
		return result;
	}

}
