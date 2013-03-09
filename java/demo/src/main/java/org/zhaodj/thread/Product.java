package org.zhaodj.thread;

public class Product {
	private static long _id=0;
	private long id;
	private boolean[] sides;
	
	public Product(){
		_id++;
		this.id=_id;
		this.sides=new boolean[]{(Math.random()>0.2),(Math.random()>0.2),(Math.random()>0.2),(Math.random()>0.2)};
	}

	public long getId() {
		return id;
	}
	
	public boolean isSideOk(int index){
		return sides[index];
	}
	
	@Override
	public String toString(){
		return "id:"+String.valueOf(id);
	}


}
