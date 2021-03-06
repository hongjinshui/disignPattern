package com.hjs.pattern.p04.singleton;

/**
 *     懒汉式，线程不安全
  *    这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
  *    因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * @author Administrator
 *
 */
public class Singleton1 {
	private static Singleton1 instance;  
    private Singleton1 (){}  
  
    public static Singleton1 getInstance() {  
    if (instance == null) {  
        instance = new Singleton1();  
    }  
    return instance;  
    }  
}
