package com.zhaodj.test;

import java.util.Scanner;

public class While {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while (true) {
			String input = in.nextLine();
			if (input.equalsIgnoreCase("bye")) {
				break;
			}
		}
	}

}
