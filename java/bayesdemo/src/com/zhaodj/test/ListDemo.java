package com.zhaodj.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListDemo {
	
	public static void main(String[] args){
		List<Integer> size=new ArrayList<Integer>(10);
		System.out.println(size.size());
		size.add(1);
		System.out.println(size.size());
		List<Integer> one=new ArrayList<Integer>();
		one.add(1);
		one.add(1);
		one.add(2);
		List<Integer> two=new ArrayList<Integer>();
		two.add(1);
		one.removeAll(two);
		System.out.println(one);
		List<Integer> demo=generateList(10);
		demo.remove(Integer.valueOf(11));
		System.out.println(demo);
		demo=demo.subList(0, 1);
		System.out.println(demo);
		/*test1(5000,10000);
		test2(5000,10000);
		test1(9000,10000);
		test2(9000,10000);
		test1(5000,100000);
		test2(5000,100000);
		test1(90000,100000);
		test2(90000,100000);*/
	}
	
	private static void test1(int inputSize,int containerSize){
		List<Integer> input=generateList(inputSize);
		List<Integer> container=generateList(containerSize);
		Date start=new Date();
		for(Integer i:input){
			if(container.contains(i)){
				continue;
			}
		}
		System.out.println("test1:"+(new Date().getTime()-start.getTime()));
	}
	
	private static void test2(int inputSize,int containerSize){
		List<Integer> input=generateList(inputSize);
		List<Integer> container=generateList(containerSize);
		Date start=new Date();
		for(Integer i:input){
			if(container.contains(i)){
				container.remove(i);
				continue;
			}
		}
		System.out.println("test2:"+(new Date().getTime()-start.getTime()));
	}
	
	private static List<Integer> generateList(int size){
		List<Integer> result=new ArrayList<Integer>(size);
		for(int i=0;i<size;i++){
			result.add(i);
		}
		return result;
	}
	

}
