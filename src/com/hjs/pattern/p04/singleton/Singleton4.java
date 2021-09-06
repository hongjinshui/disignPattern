package com.hjs.pattern.p04.singleton;
/**
 * ˫����/˫��У������DCL���� double-checked locking��
 * ���̰߳�ȫ�����ַ�ʽ����˫�����ƣ���ȫ���ڶ��߳�������ܱ��ָ����ܡ�
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
