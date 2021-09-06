package com.hjs.pattern.p6.prototype;

/**
 * 
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		Prototype example = new ConcretePrototype("1","hello");
		Prototype clonedObj = new Client().operation(example);
		((ConcretePrototype)clonedObj).setName("hi");
		Prototype clonedObj2 = example.clone();
		((ConcretePrototype)clonedObj2).setName("yo");
		System.out.println(example);
		System.out.println(clonedObj);
		System.out.println(clonedObj2);
		System.out.println();
	}
}
