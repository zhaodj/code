package org.zhaodj.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
	
	public static class Worker implements IWorker{

		@Override
		public void work() {
			System.out.println("工作");
		}

		@Override
		public void rest() {
			System.out.println("休息");
		}
		
	}
	
	/**
	 * 动态代理类
	 * @author zhaodaojun
	 *
	 */
	public static class WorkerHandler implements InvocationHandler{
		
		private IWorker worker;
		
		public WorkerHandler(IWorker worker){
			this.worker=worker;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("开始");
			Object result=method.invoke(this.worker, args);
			System.out.println("结束");
			return result;
		}
		
	}
	
	public static void main(String[] args){
		Worker worker=new Worker();
		WorkerHandler handler=new WorkerHandler(worker);
		//获取动态代理对象
		IWorker proxyWorker=(IWorker)Proxy.newProxyInstance(worker.getClass().getClassLoader(), worker.getClass().getInterfaces(), handler);
		proxyWorker.work();
		proxyWorker.rest();
	}

}
