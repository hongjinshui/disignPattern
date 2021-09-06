package com.hjs.pattern.p15.strategy;

/**
 * ���ԣ�Strategy��ģʽ�Ķ��壺��ģʽ������һϵ���㷨������ÿ���㷨��װ������ʹ���ǿ����໥�滻�����㷨�ı仯����Ӱ��ʹ���㷨�Ŀͻ���
 * ����ģʽ���ڶ�����Ϊģʽ����ͨ�����㷨���з�װ����ʹ���㷨�����κ��㷨��ʵ�ַָ������ί�ɸ���ͬ�Ķ������Щ�㷨���й���
 *
 * ����ģʽ����Ҫ�ŵ�����:
 *   1.����������䲻��ά������ʹ�ò���ģʽ���Ա���ʹ�ö���������䣬�� if...else ��䡢switch...case ��䡣
 *   2.����ģʽ�ṩ��һϵ�еĿɹ����õ��㷨�壬ǡ��ʹ�ü̳п��԰��㷨��Ĺ�������ת�Ƶ��������棬�Ӷ������ظ��Ĵ��롣
 *   3.����ģʽ�����ṩ��ͬ��Ϊ�Ĳ�ͬʵ�֣��ͻ����Ը��ݲ�ͬʱ���ռ�Ҫ��ѡ��ͬ�ġ�
 *   4.����ģʽ�ṩ�˶Կ���ԭ�������֧�֣������ڲ��޸�ԭ���������£�����������㷨��
 *   5.����ģʽ���㷨��ʹ�÷ŵ��������У����㷨��ʵ���Ƶ�����������У�ʵ���˶��ߵķ��롣
 *   
 * ����Ҫȱ������:
 *   1.�ͻ��˱���������в����㷨�������Ա���ʱѡ��ǡ�����㷨�ࡣ
 *   2.����ģʽ��ɺܶ�Ĳ����࣬����ά���Ѷȡ�
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context c = new Context();
        Strategy s = new ConcreteStrategyA();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("-----------------");
        s = new ConcreteStrategyB();
        c.setStrategy(s);
        c.strategyMethod();
    }
}

//���������
interface Strategy {
    public void strategyMethod();    //���Է���
}

//���������A
class ConcreteStrategyA implements Strategy {
    public void strategyMethod() {
        System.out.println("�������A�Ĳ��Է��������ʣ�");
    }
}

//���������B
class ConcreteStrategyB implements Strategy {
    public void strategyMethod() {
        System.out.println("�������B�Ĳ��Է��������ʣ�");
    }
}

//������
class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}


