package com.hjs.pattern.p07.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author Administrator
 *
 */
public class MainDynamic {

	/**
	 * 代理模式的定义：由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，
	 * 代理对象作为访问对象和目标对象之间的中介。
	 * 
	 * 代理模式的主要优点有：
            1.代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
            2.代理对象可以扩展目标对象的功能；
            3.代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度，增加了程序的可扩展性

    根据代理的创建时期，代理模式分为静态代理和动态代理。

    静态：由程序员创建代理类或特定工具自动生成源代码再对其编译，在程序运行前代理类的 .class 文件就已经存在了。
    动态：在程序运行时，运用反射机制动态创建而成
    
     *
	 */
	public static void main(String[] args) throws Exception {
		Calculator target = new CalculatorImpl();
		//Calculator calculatorProxy = (Calculator) getProxy(target);
		ProxyHandler handler = new ProxyHandler();
		Calculator calculatorProxy = (Calculator)handler.newProxyInstance(target);
		calculatorProxy.add(1,2);
		calculatorProxy.subtract(2,1);
	}
	
	private static Object getProxy(final Object target) throws Exception {
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),//类加载器
				target.getClass().getInterfaces(),//让代理对象和目标对象实现相同接口
				new InvocationHandler(){//代理对象的方法最终都会被JVM导向它的invoke方法
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(method.getName() + "方法开始执行...");
						Object result = method.invoke(target, args);
						System.out.println(result);
						System.out.println(method.getName() + "方法执行结束...");
						return result;
					}
				}
		);
	}
	
}
