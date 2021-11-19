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
	 * ******************************************************************************************
	 * 静态代理模式和<i>装饰器模式<i/>很像。
	 *
	 * 对装饰器模式来说，装饰者（Decorator）和被装饰者（Decoratee）都实现一个接口。对代理模式来说，
	 * 代理类（Proxy Class）和真实处理的类（Real Class）都实现同一个接口。此外，不论我们使用哪一个模式，
	 * 都可以很容易地在真实对象的方法前面或者后面加上自定义的方法。
	 *
	 * 装饰器模式是使用的调用者从外部传入的被装饰对象，调用者只想要你把他给你的对象装饰（加强）一下。
	 * 而代理模式使用的是代理对象在自己的构造方法里面new的一个被代理的对象，不是调用者传入的。调用者不知道你找了其他人，
	 * 他也不关心这些事，只要你把事情做对了即可。
	 *
	 * 装饰器模式关注于在一个对象上动态地添加方法，而代理模式关注于控制对对象的访问。
	 * 换句话说，用代理模式，代理类可以对它的客户隐藏一个对象的具体信息。因此当使用代理模式的时候，
	 * 我们常常在一个代理类中创建一个对象的实例；当使用装饰器模式的时候，我们通常的做法是将原始对象作为一个参数传给装饰器的构造器。
	 *
	 */
	public static void main(String[] args) {
		Calculator calculatorProxy = new CalculatorProxy();
		calculatorProxy.add(1, 2);
		calculatorProxy.subtract(2,1);
	}
}
