package org.zhaodj.image;

import java.io.IOException;

import org.im4java.core.ConvertCmd;
import org.im4java.core.GMOperation;
import org.im4java.process.ProcessStarter;

public class Img4javaDemo {
	
	public Img4javaDemo(){
		ProcessStarter.setGlobalSearchPath("/usr/local/bin");
	}
	
	public static void main(String[] args) throws IOException{
		Img4javaDemo demo=new Img4javaDemo();
		demo.convert("/home/zhaodj/图片/temp/1.jpg", 200, 200, 1.0f, "jpg", "/home/zhaodj/图片/temp/11.jpg");
		demo.convert("/home/zhaodj/图片/temp/2.jpg", 200, 200, 1.0f, "jpg", "/home/zhaodj/图片/temp/22.jpg");
		demo.convert("/home/zhaodj/图片/temp/3.jpg", 200, 200, 1.0f, "jpg", "/home/zhaodj/图片/temp/30.jpg");
		demo.convert("/home/zhaodj/图片/temp/3.jpg", new int[]{0,0,100,200},200, 200, 1.0f, "jpg", "/home/zhaodj/图片/temp/31.jpg");
		demo.convert("/home/zhaodj/图片/temp/3.jpg", 640, 640, 1.0f, "jpg", "/home/zhaodj/图片/temp/32.jpg");
		demo.convert("/home/zhaodj/图片/temp/3.jpg", 640, 640, 0.9f, "jpg", "/home/zhaodj/图片/temp/33.jpg");
		demo.convert("/home/zhaodj/图片/temp/3.jpg", 640, 640, 0.95f, "jpg", "/home/zhaodj/图片/temp/34.jpg");
		demo.convert("/home/zhaodj/图片/temp/4.jpg", 640, 640, 0.95f, "jpg", "/home/zhaodj/图片/temp/41.jpg");
	}
	
	public void convert(String origpath, int width, int height,
			float quality, String format, String savepath) throws IOException {
		ConvertCmd cmd = new ConvertCmd(true);
		GMOperation op = new GMOperation();
		op.addImage();
		op.resize(width, height);
		op.quality((double)quality*100);
		op.addImage();
		try {
			cmd.run(op,origpath,savepath);
		} catch (Exception e) {
			System.out.println("origpath:"+origpath+" savepath:"+savepath);
			e.printStackTrace();
		}

	}

	public void convert(String origpath, int[] region, int width, int height,
			float quality, String format, String savepath) throws IOException {
		ConvertCmd cmd = new ConvertCmd(true);
		GMOperation op = new GMOperation();
		op.addImage();
		op.crop(region[2], region[3],region[0], region[1]);
		op.resize(width, height);
		op.quality((double)quality*100);
		op.addImage();
		try {
			cmd.run(op,origpath,savepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
