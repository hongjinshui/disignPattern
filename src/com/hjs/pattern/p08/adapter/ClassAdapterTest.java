package com.hjs.pattern.p08.adapter;

//目标接口
interface Target {
	public void request();
}

//适配者接口
class Adaptee {
	public void specificRequest() {
		System.out.println("适配者中的业务代码被调用！");
	}
}

//类适配器类
class ClassAdapter extends Adaptee implements Target {
	public void request() {
		specificRequest();
	}
}

//客户端代码
public class ClassAdapterTest {
	/**
	 * 适配器模式（Adapter）的定义如下：将一个类的接口转换成客户希望的另外一个接口，
	 * 使得原本由于接口不兼容而不能一起工作的那些类能一起工作。适配器模式分为类结构型模式和对象结构型模式两种，
	 * 前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("类适配器模式测试：");
		Target target = new ClassAdapter();
		target.request();
	}
}