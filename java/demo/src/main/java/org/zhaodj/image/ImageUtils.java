package org.zhaodj.image;

import java.awt.Color;
import java.awt.Graphics2D;  
import java.awt.Image;  
import java.awt.image.BufferedImage;  
import java.awt.image.Raster;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.ImageIO;  
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.imgscalr.Scalr;
  
/** 
 * * @author WQ * @date 2011-01-14 * @versions 1.0 图片压缩工具类 提供的方法中可以设定生成的 
 * 缩略图片的大小尺寸等 
 */  
public class ImageUtils {  
    /** * 图片文件读取 * * @param srcImgPath * @return */  
    private static BufferedImage InputImage(String srcImgPath) {  
        BufferedImage srcImage = null;  
        try {  
        	/*Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("JPEG");
            ImageReader reader = null;
            while(readers.hasNext()) {
                reader = (ImageReader)readers.next();
                if(reader.canReadRaster()) {
                    break;
                }
            }
            ImageInputStream input =   ImageIO.createImageInputStream(new File(srcImgPath)); 
            reader.setInput(input); 

            //Read the image raster
            Raster raster = reader.readRaster(0, null);
            
            srcImage=new BufferedImage(raster.getWidth(), raster.getHeight(),BufferedImage.TYPE_INT_ARGB_PRE);
            srcImage.getRaster().setRect(raster);*/
            
            FileInputStream in = new FileInputStream(srcImgPath);  
            srcImage = javax.imageio.ImageIO.read(in);  
        } catch (IOException e) {  
            System.out.println("读取图片文件出错！" + e.getMessage());  
            e.printStackTrace();  
        }  
        return srcImage;  
    }  
  
    /** 
     * * 将图片按照指定的图片尺寸压缩 * * @param srcImgPath :源图片路径 * @param outImgPath * 
     * :输出的压缩图片的路径 * @param new_w * :压缩后的图片宽 * @param new_h * :压缩后的图片高 
     */  
    public static void compressImage(String srcImgPath, String outImgPath,  
            int new_w, int new_h) {  
        BufferedImage src = InputImage(srcImgPath);  
        disposeImage(src, outImgPath, new_w, new_h);  
    }  
  
    /** 
     * * 指定长或者宽的最大值来压缩图片 * * @param srcImgPath * :源图片路径 * @param outImgPath * 
     * :输出的压缩图片的路径 * @param maxLength * :长或者宽的最大值 
     */  
    public static void compressImage(String srcImgPath, String outImgPath,  
            int maxLength) {  
        // 得到图片  
        BufferedImage src = InputImage(srcImgPath);  
        if (null != src) {  
            int old_w = src.getWidth();  
            // 得到源图宽  
            int old_h = src.getHeight();  
            // 得到源图长  
            int new_w = 0;  
            // 新图的宽  
            int new_h = 0;  
            // 新图的长  
            // 根据图片尺寸压缩比得到新图的尺寸  
            if (old_w > old_h) {  
                // 图片要缩放的比例  
                new_w = maxLength;  
                new_h = (int) Math.round(old_h * ((float) maxLength / old_w));  
            } else {  
                new_w = (int) Math.round(old_w * ((float) maxLength / old_h));  
                new_h = maxLength;  
            }  
            disposeImage(src, outImgPath, new_w, new_h);  
        }  
    }  
  
    /** * 处理图片 * * @param src * @param outImgPath * @param new_w * @param new_h */  
    private synchronized static void disposeImage(BufferedImage src,  
            String outImgPath, int new_w, int new_h) {  
        // 得到图片  
        int old_w = src.getWidth();  
        // 得到源图宽  
        int old_h = src.getHeight();  
        // 得到源图长  
        BufferedImage newImg = null;  
        // 判断输入图片的类型  
        switch (src.getType()) {  
        case 13:  
            // png,gifnewImg = new BufferedImage(new_w, new_h,  
            // BufferedImage.TYPE_4BYTE_ABGR);  
            break;  
        default:  
            newImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);  
            break;  
        }  
        Graphics2D g = newImg.createGraphics();  
        // 从原图上取颜色绘制新图 
        //g.setPaint(Color.WHITE);
        //g.fillRect(0,0,new_w,new_h); 
        g.drawImage(src, 0, 0, old_w, old_h, null);
        g.dispose();  
        // 根据图片尺寸压缩比得到新图的尺寸  
        newImg.getGraphics().drawImage(  
                src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0,  
                null);  
        // 调用方法输出图片文件  
        OutImage(outImgPath, newImg);  
    }  
  
    /** 
     * * 将图片文件输出到指定的路径，并可设定压缩质量 * * @param outImgPath * @param newImg * @param 
     * per 
     */  
    private static void OutImage(String outImgPath, BufferedImage newImg) {  
        // 判断输出的文件夹路径是否存在，不存在则创建  
        File file = new File(outImgPath);  
        if (!file.getParentFile().exists()) {  
            file.getParentFile().mkdirs();  
        }// 输出到文件流  
        try {  
            ImageIO.write(newImg, outImgPath.substring(outImgPath  
                    .lastIndexOf(".") + 1), new File(outImgPath));  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    public static void main(String[] args){
    	System.out.println(Arrays.toString(ImageIO.getWriterFormatNames()));
    	compressImage("/home/zhaodj/图片/Lundlogo4-fok.jpg","/home/zhaodj/图片/Lundlogo4-fok.400x400.jpg",200,200);
    	//OutImage("/home/zhaodj/图片/T2TpxiXdNNXXXXXXXX_!!803368268.jpg.300x300.jpg",Scalr.resize(InputImage("/home/zhaodj/图片/T2TpxiXdNNXXXXXXXX_!!803368268.jpg"), 300));
    }
}  