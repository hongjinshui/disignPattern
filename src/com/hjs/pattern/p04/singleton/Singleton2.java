package com.hjs.pattern.p04.singleton;
/**
 *    ����ʽ���̰߳�ȫ
 *    ���ַ�ʽ�߱��ܺõ� lazy loading���ܹ��ڶ��߳��кܺõĹ��������ǣ�Ч�ʺܵͣ�99% ����²���Ҫͬ��
 * @author Administrator
 *
 */
public class Singleton2 {
    private static Singleton2 instance;  
    private Singleton2 (){}  
    public static synchronized Singleton2 getInstance() {  
    if (instance == null) {  
        instance = new Singleton2();  
    }  
    return instance;  
    }  
}
