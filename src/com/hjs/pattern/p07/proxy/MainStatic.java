package com.hjs.pattern.p07.proxy;

/**
 * 静态代理
 * @author Administrator
 *
 */
public class MainStatic {

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
	public static void main(String[] args) {
		Calculator calculatorProxy = new CalculatorProxy(new CalculatorImpl());
		calculatorProxy.add(1, 2);
		calculatorProxy.subtract(2,1);
	}
}
