package com.hjs.pattern.p06.prototype;

/**
 * 原型（Prototype）模式的定义如下：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。在这里，原型实例指定了要创建的对象的种类。
 * 用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 * 
 *  原型模式的优点：

    Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
    可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。

    原型模式的缺点：

    需要为每一个类都配置一个 clone 方法
    clone 方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则。
    当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦。因此，深克隆、浅克隆需要运用得当。

由于 Java 提供了对象的 clone() 方法，所以用 Java 实现原型模式很简单。
1. 模式的结构
原型模式包含以下主要角色。

    抽象原型类：规定了具体原型对象必须实现的接口。
    具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
    访问类：使用具体原型类中的 clone() 方法来复制新的对象。

原型模式通常适用于以下场景。

    对象之间相同或相似，即只是个别的几个属性不同的时候。
    创建对象成本较大，例如初始化时间长，占用CPU太多，或者占用网络资源太多等，需要优化资源。
    创建一个对象需要繁琐的数据准备或访问权限等，需要提高性能或者提高安全性。
    系统中大量使用该类对象，且各个调用者都需要给它的属性重新赋值。

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
