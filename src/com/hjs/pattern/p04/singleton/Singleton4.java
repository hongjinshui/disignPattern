package com.hjs.pattern.p04.singleton;
/**
 * ˫����/˫��У������DCL���� double-checked locking��
 * ���̰߳�ȫ�����ַ�ʽ����˫�����ƣ���ȫ���ڶ��߳�������ܱ��ָ����ܡ�
 * @author Administrator
 *
 */
public class Singleton4 {
    private volatile static Singleton4 singleton; // volatile�ɷ�ָֹ�������򣬷�ֹ���߳��»�ȡ�����ʼ���Ķ���
    private Singleton4 (){}  
    public static Singleton4 getInstance() {  
    if (singleton == null) { // ���Ϊ�գ��������������ڶ��߳��¿����ж���߳�ͨ��Ϊ���жϣ������ڼ������ٴν���Ϊ���жϣ���ֹ�����������
        synchronized (Singleton4.class) {  
        if (singleton == null) {  
            singleton = new Singleton4();  
        }  
        }  
    }  
    return singleton;  
    }
}
