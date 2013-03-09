package com.zhaodj.test;

import java.util.Arrays;

public class ArrayDemo {
	
	public static void main(String[] args){
		String[] arr1=new String[]{"*"};
		String[] arr2=new String[]{"*"};
		String[] arr3=new String[]{"jj","kk"};
		String[][] arr=new String[][]{arr1,arr2,arr3};
		int[] i=new int[]{1,2,3};
		System.out.println(Arrays.asList(i));
		System.out.println(arr3[1]);
		System.out.println(Arrays.equals(arr1, arr2));
		for(String[] a:arr){
			System.out.println(Arrays.toString(a));
		}
	}

}
