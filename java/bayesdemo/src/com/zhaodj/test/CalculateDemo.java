package com.zhaodj.test;

import java.util.Arrays;

public class CalculateDemo {
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(calculateWidthAndHeight(640,523,new int[]{200,200})));
		System.out.println(Arrays.toString(calculateWidthAndHeight(640,523,new int[]{600,600})));
		System.out.println(Arrays.toString(calculateWidthAndHeight(640,523,new int[]{960,960})));
		System.out.println(Arrays.toString(calculateWidthAndHeight(3872,2592,new int[]{960,960})));
		System.out.println(Arrays.toString(calculateWidthAndHeight(2592,3872,new int[]{960,960})));
		System.out.println(90/90%2);
		System.out.println(0/90%2);
		System.out.println(180/90%2);
		System.out.println(-90/90%2);
	}
	
	private static int[] calculateWidthAndHeight(int width,int height,int[] max){
		int[] result=new int[]{width,height};
		double scaleOrig=(double)width/height;
		double scaleMax=(double)max[0]/max[1];
		if(scaleOrig>scaleMax){
			if(width>max[0]){
				result[0]=max[0];
				result[1]=(int)Math.round(max[1]/scaleOrig);
			}
		}else{
			if(height>max[1]){
				result[0]=(int)Math.round(max[0]*scaleOrig);
				result[1]=max[1];
			}
		}
		return result;
	}

}
