package org.zhaodj.generic;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractType<E> implements IGType<E>{
	
	protected Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractType() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	public void persist(){
		System.out.println(entityClass.getName());
	}

}
