package com.hjs.pattern.p04.singleton;
/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * 多线程安全，这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * @author Administrator
 *
 */
public class Singleton4 {
    private volatile static Singleton4 singleton;  
    private Singleton4 (){}  
    public static Singleton4 getInstance() {  
    if (singleton == null) {  
        synchronized (Singleton4.class) {  
        if (singleton == null) {  
            singleton = new Singleton4();  
        }  
        }  
    }  
    return singleton;  
    }
}
