package com.hjs;

public interface Principle {
    /**
     * 六大设计原则
     * 一、单一职责原则（single responsibility principle）简称SRP原则：
     * 一个接口或者类只有一个引起变化的原因，即一个接口或者类只有一个职责，负责一件事情。（此原则同样适用于方法）
     * 好处：
     * 1、复杂性降低；2、可读性提高；3、可维护性提高；4、变更风险降低
     *
     * 二、里氏替换原则：父类能出现的地方子类就可以出现，即可以用子类替换父类。
     * 定义1：如果对每一个类型为 T1的对象 o1，都有类型为 T2 的对象o2，使得以 T1定义的所有程序 P 在所有的对象 o1 都代换成 o2 时，
     *        程序 P 的行为没有发生变化，那么类型 T2 是类型 T1 的子类型。
     * 定义2：所有引用基类的地方必须能透明地使用其子类的对象。
     * 定义解释：
     * 1、子类必须完全实现父类的方法；
     * 2、子类可以有自己的个性；
     * 3、覆盖或者实现父类的方法时，输入参数可以被放大；
     * public class Father {
     *     public Collection doSomething(HashMap map) {
     *         System.out.println("父类被执行了");
     *         return map.values();
     *     }
     * }
     *
     * public class Son extends Father {
     *     public Collection  doSomething(Map  map) {
     *         System.out.println("子类被执行了");
     *         return map.values();
     *     }
     * }
     * public static void main(String[] args) {
     *     Father father = new Father();
     *     Son son = new Son();
     *     HashMap<Object,Object> map = new HashMap<>();
     *
     *     father.doSomething(map);
     *     son.doSomething(map);
     * }
     * 以上代码执行时，子类重载了父类的doSomething方法，并且放大输入参数Hashmap→Map，执行以后，出现相同的结果，
     * 均输出"父类被执行了"，说明根据参数类型先匹配到了父类的方法，如果参数类型范围比父类方法的参数类型大，才匹配到子类的方法。
     * 这样没有歪曲父类的意图，不会引起业务逻辑混乱。
     *
     * 4、覆写或者实现父类的方法时，输出结果可以被缩小；
     *
     * 三、依赖倒置原则：
     * 1、高层不应该依赖底层，两者都应该依赖其抽象；
     * 2、抽象不应该依赖细节，细节应该依赖抽象；
     * 即模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或者抽象类产生的。
     * 更加简单的定义就是"面向接口编程（OOD：Object-Oriented Design）"
     *
     * 四、接口隔离原则
     * 定义解释：
     * 1、接口要尽量小
     * 2、接口要高内聚，高内聚就是尽量减少公布public方法
     * 3、接口要为个体提供定制服务，即只提供访问者需要的方法
     * 4、接口设计是有限度的
     * 通俗的讲，接口尽量细化，同时接口中的方法尽量少。
     * 说明：单一职责原则侧重于业务逻辑，即职责尽量少；而接口隔离原则侧重于接口中的方法尽量少。
     *
     * 五、迪米特法则
     * 也称为最少知识原则：一个对象应该对其他对象有最少的了解。通俗的讲：一个类应该对自己需要耦合或者调用的类知道的越少越好
     *
     * 六、开闭原则
     * 软件实体应该对扩展开放，对修改关闭。就是说应该通过扩展来实现变化，而不是通过修改已有的代码来实现变化。
     */
}
