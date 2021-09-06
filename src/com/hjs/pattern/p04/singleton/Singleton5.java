package com.hjs.pattern.p4.singleton;
/**
 *    �Ǽ�ʽ/��̬�ڲ���
 * ���̰߳�ȫ�����ַ�ʽ�ܴﵽ˫������ʽһ���Ĺ�Ч����ʵ�ָ��򵥡��Ծ�̬��ʹ���ӳٳ�ʼ����Ӧʹ�����ַ�ʽ������˫������ʽ��
 * ���ַ�ʽֻ�����ھ�̬��������˫������ʽ����ʵ������Ҫ�ӳٳ�ʼ��ʱʹ�á�
     ���ַ�ʽͬ�������� classloader ��������֤��ʼ�� instance ʱֻ��һ���̣߳�
     ������ 3 �ַ�ʽ��ͬ���ǣ��� 3 �ַ�ʽֻҪ Singleton �౻װ���ˣ���ô instance �ͻᱻʵ������û�дﵽ lazy loading Ч������
     �����ַ�ʽ�� Singleton �౻װ���ˣ�instance ��һ������ʼ������Ϊ SingletonHolder ��û�б�����ʹ�ã�
     ֻ��ͨ����ʽ���� getInstance ����ʱ���Ż���ʽװ�� SingletonHolder �࣬�Ӷ�ʵ���� instance��
     ����һ�£����ʵ���� instance ��������Դ�������������ӳټ��أ�
     ����һ���棬�ֲ�ϣ���� Singleton �����ʱ��ʵ������
     ��Ϊ����ȷ�� Singleton �໹�����������ĵط�������ʹ�ôӶ������أ���ô���ʱ��ʵ���� instance��
     ��Ȼ�ǲ����ʵġ����ʱ�����ַ�ʽ��ȵ� 3 �ַ�ʽ���Եúܺ���
 * @author Administrator
 *
 */
public class Singleton5 {
    private static class SingletonHolder {  
    private static final Singleton5 INSTANCE = new Singleton5();  
    }  
    private Singleton5 (){}  
    public static final Singleton5 getInstance() {  
    return SingletonHolder.INSTANCE;  
    } 
}
