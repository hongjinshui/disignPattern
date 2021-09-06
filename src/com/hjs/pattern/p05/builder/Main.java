package com.hjs.pattern.p05.builder;

public class Main {

	/**
	 * 定义：
	 *    将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示
	 * 使用场景：
	 *    当一个类的构造函数参数个数超过4个，而且这些参数有些是可选的参数，考虑使用构造者模式。
	 * 解决的问题：
	 *    当一个类的构造函数参数超过4个，而且这些参数有些是可选的时，我们通常有两种办法来构建它的对象。
	 * 1：折叠构造函数模式（telescoping constructor pattern ），即创建多个参数不同的构造函数；
	 * 2：Javabean 模式，对象创建后，通过set方法设置属性。
	 * 第一种主要是使用及阅读不方便。你可以想象一下，当你要调用一个类的构造函数时，你首先要决定使用哪一个，
	 * 然后里面又是一堆参数，如果这些参数的类型很多又都一样，你还要搞清楚这些参数的含义，很容易就传混；
	 * 第二种方式在构建过程中对象的状态容易发生变化（可以随时set属性），造成错误。因为那个类中的属性是分步设置的，所以就容易出错。
	 * 
	 * builder pattern可以解决以上两个痛点。
	 * 
	 * 实现步骤：
	 *       1.在Computer 中创建一个静态内部类 Builder，然后将Computer 中的参数都复制到Builder类中；
	 *       2.在Computer中创建一个private的构造函数，参数为Builder类型；
	 *       3.在Builder中创建一个public的构造函数，参数为Computer中必填的那些参数，cpu 和ram；
	 *       4.在Builder中创建设置函数，对Computer中那些可选参数进行赋值，返回值为Builder类型的实例；
	 *       5.在Builder中创建一个build()方法，在其中构建Computer的实例并返回。
	 * @param args
	 */
	public static void main(String[] args) {
		Computer computer = new Computer.Builder("因特尔","三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
		System.out.println(computer);
	}
}
