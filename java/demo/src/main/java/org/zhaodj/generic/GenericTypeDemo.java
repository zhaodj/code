package org.zhaodj.generic;

public class GenericTypeDemo extends AbstractType<Integer> {
	
	private Integer obj;
	
	public GenericTypeDemo(Integer object){
		this.obj=object;
	}
	
	public Integer getObj(){
		return this.obj;
	}
	
	public static void main(String[] args){
		GenericTypeDemo igt=new GenericTypeDemo(1);
		igt.persist();
	}

}
