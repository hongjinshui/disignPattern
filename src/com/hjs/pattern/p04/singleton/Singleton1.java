package com.hjs.pattern.p04.singleton;

/**
 *     ����ʽ���̲߳���ȫ
  *    ���ַ�ʽ���������ʵ�ַ�ʽ������ʵ������������ǲ�֧�ֶ��̡߳�
  *    ��Ϊû�м��� synchronized�������ϸ��������������㵥��ģʽ��
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
