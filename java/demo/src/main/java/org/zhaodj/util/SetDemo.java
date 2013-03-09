package org.zhaodj.util;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	
	public static void main(String[] args){
		Set<Integer> set=new HashSet<Integer>();
		set.add(1);
		set.add(1);
		set.remove(2);
		System.out.println(set);
	}

}
