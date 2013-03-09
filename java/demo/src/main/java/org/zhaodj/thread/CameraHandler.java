package org.zhaodj.thread;

public class CameraHandler implements Runnable{
	
	private int side;
	private Product product;

	public CameraHandler(int side){
		this.side=side;
	}
	public void setProduct(Product product){
		this.product=product;
	}
	public void run() {
		while(product!=null){
			System.out.println(product.getId()+","+product.isSideOk(this.side));
		}
	}

}
