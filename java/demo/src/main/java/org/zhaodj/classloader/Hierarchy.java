package org.zhaodj.classloader;

public class Hierarchy {
	
	public static void main(String[] args){
		ClassLoader loader=Hierarchy.class.getClassLoader();
		while(loader!=null){
			System.out.println(loader.getClass().getName());
			loader=loader.getParent();
		}
	}

}
