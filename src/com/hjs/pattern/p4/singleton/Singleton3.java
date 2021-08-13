package com.hjs.pattern.p4.singleton;
/**
 *   ����ʽ
 *   ���̰߳�ȫ,���ַ�ʽ�Ƚϳ��ã������ײ�����������,�����ʱ�ͳ�ʼ�����˷��ڴ�
 *   ������ classloader ���Ʊ����˶��̵߳�ͬ�����⣬������instance ����װ��ʱ��ʵ������
 *   ��Ȼ������װ�ص�ԭ���кܶ��֣��ڵ���ģʽ�д�������ǵ��� getInstance ������ 
 *   ����Ҳ����ȷ���������ķ�ʽ�����������ľ�̬������������װ�أ�
 *   ��ʱ���ʼ�� instance ��Ȼû�дﵽ lazy loading ��Ч����
 * @author Administrator
 *
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();  
    private Singleton3 (){}  
    public static Singleton3 getInstance() {  
    return instance;  
    }  
}
