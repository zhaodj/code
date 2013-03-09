package org.zhaodj.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.oro.io.AwkFilenameFilter;

public class UpdateThumbnail {
	
	private List<Image> images;
	private String[][] suffixes=new String[][]{{"_560x560.jpg","_200x520.jpg","_100x260.jpg"},{"_584x1200.jpg","_218x520.jpg","_80x80.jpg"}};
	private Img4javaDemo img4java;
	
	public UpdateThumbnail(){
		img4java=new Img4javaDemo();
	}
	
	public static void main(String[] args) throws IOException{
		UpdateThumbnail up=new UpdateThumbnail();
		up.findAllNeedConvert(args[0]);//args[0] "/home/zhaodj/图片/temp/temp"
		up.convert();
	}
	
	private void findAllNeedConvert(String path){
		File file=new File(path);
		if(file.isDirectory()){
			FilenameFilter filter=new AwkFilenameFilter("12\\d{4}");
			File[] folders=file.listFiles(filter);
			this.images=new ArrayList<Image>();
			for(File f:folders){
				initImages(f);
			}
		}
	}
	
	private void initImages(File file){
		if(file.isDirectory()){
			String[] origs=file.list(new AwkFilenameFilter("[0-9a-f]+\\.[a-zA-Z]+"));
			String path=file.getAbsolutePath()+File.separator;
			if(origs.length>0){
				List<String> allFiles=Arrays.asList(file.list());
				for(String orig:origs){
					addImage(path,orig,allFiles,suffixes[0]);
					addImage(path,orig,allFiles,suffixes[1]);
				}
			}
		}
	}
	
	private void addImage(String path,String orig,List<String> allFiles,String[] suffix){
		String origname=orig.replaceAll("\\.[a-zA-Z]+", "");
		String large=origname+suffix[0];
		String medium=origname+suffix[1];
		String small=origname+suffix[2];
		if(allFiles.contains(large)&&allFiles.contains(medium)&&allFiles.contains(small)){
			images.add(new Image(path+orig,path+large,path+medium,path+small));
		}
	}
	
	private void convert() throws IOException{
		for(Image img:this.images){
			BufferedImage orig = ImageIO.read(new File(img.orig));
			int width=orig.getWidth();
			int height=orig.getHeight();
			int[] largeSize=getLargeSize(width,height);
			img4java.convert(img.orig, largeSize[0], largeSize[1], 0.9f, "jpg", img.large);
			img4java.convert(img.orig, 310, 310, 0.9f, "jpg", img.medium);
			img4java.convert(img.orig, 200, 200, 0.9f, "jpg", img.small);
			/*
			int[] smallSize=getSmallSize(orig.getWidth(),orig.getHeight());
			//System.out.println(Arrays.toString(smallSize));
			Thumbnails.of(orig).size(largeSize[0], largeSize[1]).outputQuality(1.0f).outputFormat("jpg").toFile(img.large);
			Thumbnails.of(orig).size(218, 520).outputQuality(1.0f).outputFormat("jpg").toFile(img.medium);
			Thumbnails.of(orig).size(smallSize[0], smallSize[1]).outputQuality(1.0f).outputFormat("jpg").toFile(img.small);*/
			orig.flush();
		}
	}
	
	private int[] getLargeSize(int width,int height){
		int[] result = new int[2];
		if(width<640&&height<640){
			result[0]=width;
			result[1]=height;
		}
		else{
			result[0]=640;
			result[1]=640;
		}
		return result;
	}
	
	private int[] getSmallSize(int width,int height){
		double ratio=(double)width/height;
		int[] result=new int[2];
		if(ratio>1){
			result[1]=80;
			result[0]=(int) Math.ceil(80*ratio);
		}
		else{
			result[0]=80;
			result[1]=(int) Math.ceil(80/ratio);
		}
		return result;
	}
	
	
	private class Image{
		public String orig;
		public String large;
		public String medium;
		public String small;
		
		public Image(String orig,String large,String medium,String small){
			this.orig=orig;
			this.large=large;
			this.medium=medium;
			this.small=small;
		}
		@Override
		public String toString(){
			return "orig="+orig+",large="+large+",medium="+medium+",small="+small;
		}
	}

}
