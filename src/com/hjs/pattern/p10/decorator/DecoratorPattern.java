package com.hjs.pattern.p10.decorator;

public class DecoratorPattern {
	/**
	 * 
	 * 装饰器（Decorator）模式的定义：指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，
	 * 它属于对象结构型模式。
	 * 
	 * 装饰器模式的主要优点有： 
	 *    1.装饰器是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用
	 *    2.通过使用不用装饰类及这些装饰类的排列组合，可以实现不同效果
	 *    3.装饰器模式完全遵守开闭原则
	 *    
	 *通常情况下，扩展一个类的功能会使用继承方式来实现。但继承具有静态特征，耦合度高，并且随着扩展功能的增多，子类会很膨胀。
	 *如果使用组合关系来创建一个包装对象（即装饰对象）来包裹真实对象，并在保持真实对象的类结构不变的前提下，为其提供额外的功能，
	 *这就是装饰器模式的目标。
     *
     ******************************************************************************************
     * 装饰器模式和<i>静态代理模式<i/>很像。
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
        Component p = new ConcreteComponent();
        p.operation();
        System.out.println("---------------------------------");
        Component d = new ConcreteDecorator(p);
        d.operation();
    }
}
//抽象构件角色
interface Component {
    public void operation();
}
//具体构件角色
class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("创建具体构件角色");
    }
    public void operation() {
        System.out.println("调用具体构件角色的方法operation()");
    }
}
//抽象装饰角色
class Decorator implements Component {
    private Component component;
    public Decorator(Component component) {
        this.component = component;
    }
    public void operation() {
        component.operation();
    }
}
//具体装饰角色
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    public void operation() {
        super.operation();
        addedFunction();
    }
    public void addedFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}
