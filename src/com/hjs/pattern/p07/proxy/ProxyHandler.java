package com.hjs.pattern.p07.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler{

	private Object target;
	
	public Object newProxyInstance(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this); 
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass().getName());
		System.out.println(method.getName() + "方法开始执行...");
		Object result = method.invoke(target, args);
		System.out.println(result);
		System.out.println(method.getName() + "方法执行结束...");
		return result;
	}

}
