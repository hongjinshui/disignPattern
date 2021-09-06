package com.hjs.pattern.p17.chain_of_responsibility;

/**
 * ������/ְ����ģʽ��Chain of Responsibility��ģʽ�Ķ��壺Ϊ�˱����������������������������һ��
 * ���ǽ���������Ĵ�����ͨ��ǰһ�����ס����һ����������ö�����һ����������������ʱ���ɽ������������������ݣ�ֱ���ж�������Ϊֹ��
 * 
 * ��������ģʽ�У��ͻ�ֻ��Ҫ�������͵��������ϼ��ɣ������������Ĵ���ϸ�ں�����Ĵ��ݹ��̣�������Զ����д��ݡ�
 * ����������������ķ����ߺ�����Ĵ����߽����ˡ�
 * 
 * ������ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ����£�
 *     1.�����˶���֮�����϶ȡ���ģʽʹ��һ����������֪����������һ���������������Լ����Ľṹ�������ߺͽ�����Ҳ����ӵ�жԷ�����ȷ��Ϣ��
 *     2.��ǿ��ϵͳ�Ŀ���չ�ԡ����Ը�����Ҫ�����µ��������࣬���㿪��ԭ��
 *     3.��ǿ�˸�����ָ��ְ�������ԡ����������̷����仯�����Զ�̬�ظı����ڵĳ�Ա���ߵ������ǵĴ���Ҳ�ɶ�̬����������ɾ�����Ρ�
 *     4.���������˶���֮������ӡ�ÿ������ֻ�豣��һ��ָ�������ߵ����ã����豣���������д����ߵ����ã��������ʹ���ڶ�� if ���� if������else ��䡣
 *     5.���ηֵ���ÿ����ֻ��Ҫ�����Լ��ô���Ĺ��������ô���Ĵ��ݸ���һ��������ɣ���ȷ��������η�Χ��������ĵ�һְ��ԭ��
 * 
 * ����Ҫȱ�����£�
 *     1.���ܱ�֤ÿ������һ������������һ������û����ȷ�Ľ����ߣ����Բ��ܱ�֤��һ���ᱻ�������������һֱ��������ĩ�˶��ò�������
 *     2.�ԱȽϳ���ְ����������Ĵ�������漰����������ϵͳ���ܽ��ܵ�һ��Ӱ�졣
 *     3.ְ���������ĺ�����Ҫ���ͻ�������֤�������˿ͻ��˵ĸ����ԣ����ܻ�����ְ�����Ĵ������ö�����ϵͳ��������ܻ����ѭ�����á�
 *
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        //��װ������
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //�ύ����
        handler1.handleRequest("two");
    }
}

//�������߽�ɫ
abstract class Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    //��������ķ���
    public abstract void handleRequest(String request);
}

//���崦���߽�ɫ1
class ConcreteHandler1 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("one")) {
            System.out.println("���崦����1�����������");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("û���˴��������");
            }
        }
    }
}

//���崦���߽�ɫ2
class ConcreteHandler2 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("���崦����2�����������");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("û���˴��������");
            }
        }
    }
}


