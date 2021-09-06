package com.hjs.pattern.p21.iterator;

import java.util.*;

/**
 * ��������Iterator��ģʽ�Ķ��壺�ṩһ��������˳����ʾۺ϶����е�һϵ�����ݣ�������¶�ۺ϶�����ڲ���ʾ��
 * ������ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ����¡�
 *
 * ����ʵ�����Լ���������У�����Ҫ����һ���ۺ϶����еĸ���Ԫ�أ��硰���ݽṹ���е����������ͨ���������ǽ�����Ĵ����ͱ���������ͬһ�����У�
 * �����ַ�ʽ�����ڳ������չ�����Ҫ�������������ͱ����޸ĳ���Դ���룬��Υ���� ������ԭ�򡱡�
 * 
 * ��Ȼ������������װ�ھۺ����в���ȡ����ô�ۺ����в��ṩ�����������������������û��Լ�ʵ���Ƿ�����أ�����ͬ������ȡ��
 * ��Ϊ���ַ�ʽ���������ȱ�㣺
 *    1.��¶�˾ۺ�����ڲ���ʾ��ʹ�����ݲ���ȫ��
 *    2.�����˿ͻ��ĸ�����
 *    
 * ��������ģʽ���ܽϺõؿ˷�����ȱ�㣬���ڿͻ���������ۺ���֮�����һ����������������˾ۺ϶������������Ϊ���Կͻ�Ҳ���������ڲ�ϸ�ڣ�
 * �����㡰��һְ��ԭ�򡱺͡�����ԭ�򡱣��� Java �е� Collection��List��Set��Map �ȶ������˵�������
 * 
 * ������ģʽ��������Ӧ�õıȽϹ㷺�����磺����ϵͳ�еĴ��ʹ������ܴ��͵���ʲô��Ʒ�����ᱻ�����һ�������ӣ�������һ��ͳһ�Ķ�ά�롣
 * �������ǲ���Ҫ������������ʲô���ڷַ�ʱֻ��Ҫһ������鷢�͵�Ŀ�ĵؼ��ɡ��ٱ��磬����ƽʱ������ͨ���ߣ�
 * ����ͳһˢ������ˢ����վ��������Ҫ���������Ի���Ů�ԡ��ǲм��˻��������˵���Ϣ��
 * 
 * ��������Iterator��ģʽ�Ķ��壺�ṩһ��������˳����ʾۺ϶����е�һϵ�����ݣ�������¶�ۺ϶�����ڲ���ʾ��
 * ������ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ�����:
 *     1.����һ���ۺ϶�������ݶ����뱩¶�����ڲ���ʾ��
 *     2.���������ɵ�������ɣ�����˾ۺ��ࡣ
 *     3.��֧���Բ�ͬ��ʽ����һ���ۺϣ����������Զ����������������֧���µı�����
 *     4.�����µľۺ���͵������඼�ܷ��㣬�����޸�ԭ�д��롣
 *     5.��װ�����ã�Ϊ������ͬ�ľۺϽṹ�ṩһ��ͳһ�Ľӿڡ�
 * 
 * ����Ҫȱ���ǣ�
 *     1.��������ĸ���������һ���̶���������ϵͳ�ĸ����ԡ�
 * 
 */
public class IteratorPattern {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("��ɽ��ѧ");
        ag.add("������");
        ag.add("�ع�ѧԺ");
        System.out.print("�ۺϵ������У�");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.print(ob.toString() + "\t");
        }
        Object ob = it.first();
        System.out.println("\nFirst��" + ob.toString());
    }
}

//����ۺ�
interface Aggregate {
	
    public void add(Object obj);

    public void remove(Object obj);

    public Iterator getIterator();
}

//����ۺ�
class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<Object>();

    public void add(Object obj) {
        list.add(obj);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }

    public Iterator getIterator() {
        return (new ConcreteIterator(list));
    }
}

//���������
interface Iterator {
    Object first();

    Object next();

    boolean hasNext();
}

//���������
class ConcreteIterator implements Iterator {
    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public Object first() {
        index = 0;
        Object obj = list.get(index);
        return obj;
    }

    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }
}

