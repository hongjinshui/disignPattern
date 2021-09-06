package com.hjs.pattern.p19.observer;

import java.util.*;

/**
 * �۲��ߣ�Observer��ģʽ�Ķ��壺ָ�����������һ�Զ��������ϵ����һ�������״̬�����ı�ʱ���������������Ķ��󶼵õ�֪ͨ�����Զ����¡�
 * ����ģʽ��ʱ�ֳ�������-����ģʽ��ģ��-��ͼģʽ�����Ƕ�����Ϊ��ģʽ��
 *
 * �۲���ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ����¡�
 *     1.������Ŀ����۲���֮�����Ϲ�ϵ������֮���ǳ�����Ϲ�ϵ��������������ԭ��
 *     2.Ŀ����۲���֮�佨����һ�״������ơ�
 * 
 * ������Ҫȱ�����¡�
 *     1.Ŀ����۲���֮���������ϵ��û����ȫ����������п��ܳ���ѭ�����á�
 *     2.���۲��߶���ܶ�ʱ��֪ͨ�ķ����Ứ�Ѻܶ�ʱ�䣬Ӱ������Ч�ʡ�
 *     
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer obs1 = new ConcreteObserver1();
        Observer obs2 = new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}

//����Ŀ��
abstract class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();

    //���ӹ۲��߷���
    public void add(Observer observer) {
        observers.add(observer);
    }

    //ɾ���۲��߷���
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObserver(); //֪ͨ�۲��߷���
}

//����Ŀ��
class ConcreteSubject extends Subject {
    public void notifyObserver() {
        System.out.println("����Ŀ�귢���ı�...");
        System.out.println("--------------");

        for (Object obs : observers) {
            ((Observer) obs).response();
        }

    }
}

//����۲���
interface Observer {
    void response(); //��Ӧ
}

//����۲���1
class ConcreteObserver1 implements Observer {
    public void response() {
        System.out.println("����۲���1������Ӧ��");
    }
}

//����۲���1
class ConcreteObserver2 implements Observer {
    public void response() {
        System.out.println("����۲���2������Ӧ��");
    }
}
