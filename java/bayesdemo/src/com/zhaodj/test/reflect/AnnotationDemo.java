package com.zhaodj.test.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnotationDemo {
	
	@Length(10)
	private String name;
	
	public AnnotationDemo(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args){
		List<AnnotationDemo> list=new ArrayList<AnnotationDemo>();
		for(int i=0;i<10000;i++){
			list.add(new AnnotationDemo("记录记录进口量就丢郭卡拉绝对卡洛斯附近格拉记录积分科技股垃圾就刚拉萨进口量国家队卡拉"));
		}
		List<AnnotationDemo> list1=new ArrayList<AnnotationDemo>();
		for(int i=0;i<10000;i++){
			list1.add(new AnnotationDemo("记录记录进口量就丢郭卡拉绝对卡洛斯附近格拉记录积分科技股垃圾就刚拉萨进口量国家队卡拉"));
		}
		System.out.println("普通："+commonSub(list));
		System.out.println("反射："+reflectSub(list1));
	}
	
	private static long commonSub(List<AnnotationDemo> list){
		long start=new Date().getTime();
		int i=0;
		for(AnnotationDemo o:list){
			o.setName(o.getName().substring(0, 10));
			i++;
		}
		System.out.println(i);
		return new Date().getTime()-start;
	}
	
	private static long reflectSub(List<AnnotationDemo> list){
		long start=new Date().getTime();
		int i=0;
		for(AnnotationDemo o:list){
			Class classType=o.getClass();
			Field[] fields=classType.getDeclaredFields();
			for(Field field:fields){
				if(field.isAnnotationPresent(Length.class)&&String.class.equals(field.getType())){
					Length length=field.getAnnotation(Length.class);
					String fieldName=field.getName();   
		            String stringLetter=fieldName.substring(0, 1).toUpperCase();   
		               
		            //获得相应属性的getXXX和setXXX方法名称   
		            String getName="get"+stringLetter+fieldName.substring(1);   
		            String setName="set"+stringLetter+fieldName.substring(1);
		            try{
		            //获取相应的方法   
		            Method getMethod=classType.getMethod(getName, new Class[]{});   
		            Method setMethod=classType.getMethod(setName, new Class[]{field.getType()});   
		               
		            //调用getXXX()方法   
		            String value=(String)getMethod.invoke(o, new Object[]{});   
		            if(value!=null&&value.length()>length.value()){
			            //调用setXXX()方法   
			            setMethod.invoke(o,new Object[]{value.substring(0, length.value())}); 
			            i++;
		            }
		            }
		            catch(Exception e){
		            	e.printStackTrace();
		            }
				}
			}
		}
		System.out.println(i);
		return new Date().getTime()-start;
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Length{
		int value();
	}

}
