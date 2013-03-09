package com.zhaodj.test;

public class EnumSwitchDemo {
	
	public static enum Type{
		A,B,C
	}
	
	public static enum Role{
		user,editor,admin,contributor;
	}
	
	private Role role;
	
	public static void main(String[] args){
		Type b=Type.B;
		test(b);
		EnumSwitchDemo demo=new EnumSwitchDemo();
		demo.setRole(Role.editor);
		System.out.println(demo.getRole());
		Type c=Type.valueOf("C");
		test(c);
	}
	
	public static void test(Type type){
		switch(type){
			case A:
				System.out.println("a");
			case B:
				System.out.println("b");
			case C:
				System.out.println("c");
		}
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
