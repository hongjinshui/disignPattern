package com.hjs.pattern.p23.memento;

/**
 * ����¼��Memento��ģʽ�Ķ��壺�ڲ��ƻ���װ�Ե�ǰ���£�����һ��������ڲ�״̬�����ڸö���֮�Ᵽ�����״̬��
 * �Ա��Ժ���Ҫʱ�ܽ��ö���ָ���ԭ�ȱ����״̬����ģʽ�ֽп���ģʽ��
 * 
 * ����¼ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ����£�
 *   1.�ṩ��һ�ֿ��Իָ�״̬�Ļ��ơ����û���Ҫʱ�ܹ��ȽϷ���ؽ����ݻָ���ĳ����ʷ��״̬��
 *   2.ʵ�����ڲ�״̬�ķ�װ�����˴������ķ�����֮�⣬�������󶼲��ܹ�������Щ״̬��Ϣ��
 *   3.���˷������ࡣ�����˲���Ҫ����ͱ������ڲ�״̬�ĸ������ݣ�����״̬��Ϣ�������ڱ���¼�У����ɹ����߽��й�������ϵ�һְ��ԭ��
 * 
 * ����Ҫȱ���ǣ���Դ���Ĵ����Ҫ������ڲ�״̬��Ϣ��������ر�Ƶ��������ռ�ñȽϴ���ڴ���Դ��
 * 
 */
public class MementoPattern {
    public static void main(String[] args) {
        Originator or = new Originator();
        Caretaker cr = new Caretaker();
        or.setState("S0");
        System.out.println("��ʼ״̬:" + or.getState());
        cr.setMemento(or.createMemento()); //����״̬
        or.setState("S1");
        System.out.println("�µ�״̬:" + or.getState());
        or.restoreMemento(cr.getMemento()); //�ָ�״̬
        System.out.println("�ָ�״̬:" + or.getState());
    }
}
//����¼
class Memento {
    private String state;
    public Memento(String state) {
        this.state = state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
//������
class Originator {
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public Memento createMemento() {
        return new Memento(state);
    }
    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}
//������
class Caretaker {
    private Memento memento;
    public void setMemento(Memento m) {
        memento = m;
    }
    public Memento getMemento() {
        return memento;
    }
}