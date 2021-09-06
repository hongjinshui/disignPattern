package com.hjs.pattern.p13.composite;

import java.util.ArrayList;

/**
 * 组合（Composite Pattern）模式的定义：有时又叫作整体-部分（Part-Whole）模式，它是一种将对象组合成树状的层次结构的模式，
 * 用来表示“整体-部分”的关系，使用户对单个对象和组合对象具有一致的访问性，属于结构型设计模式。
 * 
 * 组合模式一般用来描述整体与部分的关系，它将对象组织到树形结构中，顶层的节点被称为根节点，根节点下面可以包含树枝节点和叶子节点，
 * 树枝节点下面又可以包含树枝节点和叶子节点。
 * 
 * 其实根节点和树枝节点本质上属于同一种数据类型，可以作为容器使用；而叶子节点与树枝节点在语义上不属于用一种类型。
 * 但是在组合模式中，会把树枝节点和叶子节点看作属于同一种数据类型（用统一接口定义），让它们具备一致行为。
 * 这样，在组合模式中，整个树形结构中的对象都属于同一种类型，带来的好处就是用户不需要辨别是树枝节点还是叶子节点，
 * 可以直接进行操作，给用户的使用带来极大的便利。
 * 
 * 组合模式的主要优点有： 
 *   1.组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码；
 *   2.更容易在组合体内加入新的对象，客户端不会因为加入了新的对象而更改源代码，满足“开闭原则”；
 *  
 * 其主要缺点是： 
 *   1.设计较复杂，客户端需要花更多时间理清类之间的层次关系；
 *   2.不容易限制容器中的构件；
 *   3.不容易用继承的方法来增加构件的新功能；
 *   
 * 组合模式分为透明式的组合模式和安全式的组合模式。
 * 
 */
public class CompositePatternSecure {
	/**
	 *   (2) 安全方式
	 *   在该方式中，将管理子构件的方法移到树枝构件中，抽象构件和树叶构件没有对子对象的管理方法，这样就避免了上一种方式的安全性问题，
	 *   但由于叶子和分支有不同的接口，客户端在调用时要知道树叶对象和树枝对象的存在，所以失去了透明性。
	 * 
	 */
    public static void main(String[] args) {
    	CompositeSecure c0 = new CompositeSecure();
    	CompositeSecure c1 = new CompositeSecure();
        ComponentSecure leaf1 = new LeafSecure("1");
        ComponentSecure leaf2 = new LeafSecure("2");
        ComponentSecure leaf3 = new LeafSecure("3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}
//抽象构件
interface ComponentSecure {
    public void operation();
}
//树叶构件
class LeafSecure implements ComponentSecure {
    private String name;
    public LeafSecure(String name) {
        this.name = name;
    }
    public void add(ComponentSecure c) {
    }
    public void remove(ComponentSecure c) {
    }
    public ComponentSecure getChild(int i) {
        return null;
    }
    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}
//树枝构件
class CompositeSecure implements ComponentSecure {
    private ArrayList<ComponentSecure> children = new ArrayList<ComponentSecure>();
    public void add(ComponentSecure c) {
        children.add(c);
    }
    public void remove(ComponentSecure c) {
        children.remove(c);
    }
    public ComponentSecure getChild(int i) {
        return children.get(i);
    }
    public void operation() {
        for (Object obj : children) {
            ((ComponentSecure) obj).operation();
        }
    }
}
