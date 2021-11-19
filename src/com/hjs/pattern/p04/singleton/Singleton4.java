package com.hjs.pattern.p04.singleton;
/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * 多线程安全，这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * @author Administrator
 *
 */
public class Singleton4 {
    private volatile static Singleton4 singleton; // volatile可防止指令重排序，防止多线程下获取到半初始化的对象
    private Singleton4 (){}  
    public static Singleton4 getInstance() {  
    if (singleton == null) { // 如果为空，加锁创建对象，在多线程下可能有多个线程通过为空判断，所以在加锁后再次进行为空判断，防止创建多个对象
        synchronized (Singleton4.class) {  
        if (singleton == null) {  
            singleton = new Singleton4();  
        }  
        }  
    }  
    return singleton;  
    }
}
