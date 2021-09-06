package com.hjs.pattern.p20.mediator;
import java.util.*;

/**
 * �н��ߣ�Mediator��ģʽ�Ķ��壺����һ���н��������װһϵ�ж���֮��Ľ�����ʹԭ�ж���֮��������ɢ���ҿ��Զ����ظı�����֮��Ľ�����
 * �н���ģʽ�ֽе�ͣģʽ�����ǵ����ط���ĵ���Ӧ�á�
 * 
 * �н���ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ����¡�
 *     1.��֮���˾��ְ�����ϵ����ط���
 *     2.�����˶���֮�������ԣ�ʹ�ö������ڶ����ر����á�
 *     3.��������һ�Զ����ת��Ϊһ��һ�Ĺ��������ϵͳ������ԣ�ʹ��ϵͳ����ά������չ��
 * 
 * ����Ҫȱ���ǣ�
 *     1.�н���ģʽ��ԭ���������ֱ�ӵ��໥����������н��ߺͶ��ͬ�����������ϵ����ͬ����Խ��ʱ���н��߾ͻ�Խӷ�ף���ø���������ά����
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1, c2, c3;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        c3 = new ConcreteColleague3();
        md.register(c1);
        md.register(c2);
        md.register(c3);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}

//�����н���
abstract class Mediator {
    public abstract void register(Colleague colleague);

    public abstract void relay(Colleague cl); //ת��
}

//�����н���
class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<Colleague>();

    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    public void relay(Colleague cl) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(cl)) {
                ((Colleague) ob).receive();
            }
        }
    }
}

//����ͬ����
abstract class Colleague {
    protected Mediator mediator;

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}

//����ͬ����
class ConcreteColleague1 extends Colleague {
    public void receive() {
        System.out.println("����ͬ����1�յ�����");
    }

    public void send() {
        System.out.println("����ͬ����1��������");
        mediator.relay(this); //���н���ת��
    }
}

//����ͬ����
class ConcreteColleague2 extends Colleague {
    public void receive() {
        System.out.println("����ͬ����2�յ�����");
    }

    public void send() {
        System.out.println("����ͬ����2��������");
        mediator.relay(this); //���н���ת��
    }
}

//����ͬ����
class ConcreteColleague3 extends Colleague {
  public void receive() {
      System.out.println("����ͬ����3�յ�����");
  }

  public void send() {
      System.out.println("����ͬ����3��������");
      mediator.relay(this); //���н���ת��
  }
}


