package com.hjs.pattern.p09.bridge;

/**
 * 
 * �Žӣ�Bridge��ģʽ�Ķ������£���������ʵ�ַ��룬ʹ���ǿ��Զ����仯����������Ϲ�ϵ����̳й�ϵ��ʵ�֣�
 * �Ӷ������˳����ʵ���������ɱ�ά�ȵ���϶ȡ�
 * 
 * �Ž�ģʽ��ѭ�������滻ԭ�����������ԭ������ʵ���˿���ԭ�򣬶��޸Ĺرգ�����չ���š����ｫ�Ž�ģʽ����ȱ���ܽ����¡�
 * �Žӣ�Bridge��ģʽ���ŵ��ǣ�
 *    1.������ʵ�ַ��룬��չ����ǿ
 *    2.���Ͽ���ԭ��
 *    3.���Ϻϳɸ���ԭ��
 *    4.��ʵ��ϸ�ڶԿͻ�͸��
 *
 */
public class BridgeTest {
    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.Operation();
    }
}
//ʵ�ֻ���ɫ
interface Implementor {
    public void OperationImpl();
}
//����ʵ�ֻ���ɫ
class ConcreteImplementorA implements Implementor {
    public void OperationImpl() {
        System.out.println("����ʵ�ֻ�(Concrete Implementor)��ɫ������");
    }
}
//���󻯽�ɫ
abstract class Abstraction {
    protected Implementor imple;
    protected Abstraction(Implementor imple) {
        this.imple = imple;
    }
    public abstract void Operation();
}
//��չ���󻯽�ɫ
class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor imple) {
        super(imple);
    }
    public void Operation() {
        System.out.println("��չ����(Refined Abstraction)��ɫ������");
        imple.OperationImpl();
    }
}