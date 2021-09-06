package com.hjs.pattern.p12.flyweight;

import java.util.HashMap;

public class FlyweightPattern {
	/**
	 * ��Ԫ��Flyweight��ģʽ�Ķ��壺���ù���������Ч��֧�ִ���ϸ���ȶ���ĸ��á�
	 * ��ͨ�������Ѿ����ڵĶ���������ȼ�����Ҫ�����Ķ����������������������Ŀ������Ӷ����ϵͳ��Դ�������ʡ�
	 * 
	 * ��Ԫģʽ����Ҫ�ŵ��ǣ���ͬ����ֻҪ����һ�ݣ��⽵����ϵͳ�ж�����������Ӷ�������ϵͳ��ϸ���ȶ�����ڴ������ѹ����
	 * ����Ҫȱ���ǣ�
	 *    1.Ϊ��ʹ������Թ�����Ҫ��һЩ���ܹ����״̬�ⲿ�����⽫���ӳ���ĸ����ԡ�
	 *    2.��ȡ��Ԫģʽ���ⲿ״̬��ʹ������ʱ����΢�䳤��
	 *    
	 * ��Ԫģʽ�Ķ������������Ҫ��ϸ���Ⱥ͹��������ΪҪ��ϸ���ȣ����Բ��ɱ���ػ�ʹ���������������������
	 * ��ʱ���Ǿͽ���Щ�������Ϣ��Ϊ�������֣��ڲ�״̬���ⲿ״̬��
	 * �ڲ�״ָ̬�������������Ϣ���洢����Ԫ��Ϣ�ڲ������Ҳ����滷���ĸı���ı䣻
	 * �ⲿ״ָ̬�������������һ����ǣ��滷���ĸı���ı䣬���ɹ���
	 * 
	 * ���磬���ӳ��е����Ӷ��󣬱��������Ӷ����е��û��������롢����URL����Ϣ���ڴ��������ʱ������ú��ˣ�
	 * �����滷���ĸı���ı䣬��ЩΪ�ڲ�״̬������ÿ������Ҫ����������ʱ��������Ҫ�������Ϊ����״̬����ЩΪ�ⲿ״̬��
	 * 
	 * ��Ԫģʽ����Ҫ��ɫ������:
	 *    1.������Ԫ��ɫ��Flyweight���������еľ�����Ԫ��Ļ��࣬Ϊ������Ԫ�淶��Ҫʵ�ֵĹ����ӿڣ�����Ԫ���ⲿ״̬�Բ�������ʽͨ���������롣
	 *    2.������Ԫ��Concrete Flyweight����ɫ��ʵ�ֳ�����Ԫ��ɫ�����涨�Ľӿڡ�
	 *    3.����Ԫ��Unsharable Flyweight)��ɫ���ǲ����Թ�����ⲿ״̬�����Բ�������ʽע�������Ԫ����ط����С�
	 *    4.��Ԫ������Flyweight Factory����ɫ�����𴴽��͹�����Ԫ��ɫ�����ͻ���������һ����Ԫ����ʱ��
	 *      ��Ԫ�������ϵͳ���Ƿ���ڷ���Ҫ�����Ԫ��������������ṩ���ͻ�����������ڵĻ����򴴽�һ���µ���Ԫ����
	 */
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f01 = factory.getFlyweight("a");
        Flyweight f02 = factory.getFlyweight("a");
        Flyweight f03 = factory.getFlyweight("a");
        Flyweight f11 = factory.getFlyweight("b");
        Flyweight f12 = factory.getFlyweight("b");
        f01.operation(new UnsharedConcreteFlyweight("��1�ε���a��"));
        f02.operation(new UnsharedConcreteFlyweight("��2�ε���a��"));
        f03.operation(new UnsharedConcreteFlyweight("��3�ε���a��"));
        f11.operation(new UnsharedConcreteFlyweight("��1�ε���b��"));
        f12.operation(new UnsharedConcreteFlyweight("��2�ε���b��"));
    }
}
//����Ԫ��ɫ
class UnsharedConcreteFlyweight {
    private String info;
    UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
//������Ԫ��ɫ
interface Flyweight {
    public void operation(UnsharedConcreteFlyweight state);
}
//������Ԫ��ɫ
class ConcreteFlyweight implements Flyweight {
    private String key;
    ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("������Ԫ" + key + "��������");
    }
    public void operation(UnsharedConcreteFlyweight outState) {
        System.out.print("������Ԫ" + key + "�����ã�");
        System.out.println("����Ԫ��Ϣ��:" + outState.getInfo());
    }
}
//��Ԫ������ɫ
class FlyweightFactory {
    private HashMap<String, Flyweight> flyweights = new HashMap<String, Flyweight>();
    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = (Flyweight) flyweights.get(key);
        if (flyweight != null) {
            System.out.println("������Ԫ" + key + "�Ѿ����ڣ����ɹ���ȡ��");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}