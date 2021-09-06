package com.hjs.pattern.p14.template_method;

/**
 * ģ�巽����Template Method��ģʽ�Ķ������£�
 * ����һ�������е��㷨�Ǽܣ������㷨��һЩ�����ӳٵ������У�ʹ��������Բ��ı���㷨�ṹ��������ض�����㷨��ĳЩ�ض����衣
 * ����һ������Ϊ��ģʽ��
 * 
 * ��ģʽ����Ҫ�ŵ�����:
 *    1.����װ�˲��䲿�֣���չ�ɱ䲿�֡�������Ϊ�ǲ��䲿�ֵ��㷨��װ��������ʵ�֣����ѿɱ䲿���㷨������̳�ʵ�֣��������������չ��
 *    2.���ڸ�������ȡ�˹����Ĳ��ִ��룬���ڴ��븴�á�
 *    3.���ַ�����������ʵ�ֵģ�����������ͨ����չ��ʽ������Ӧ�Ĺ��ܣ����Ͽ���ԭ��
 *    
 * ��ģʽ����Ҫȱ������:
 *    1.��ÿ����ͬ��ʵ�ֶ���Ҫ����һ�����࣬��ᵼ����ĸ������ӣ�ϵͳ�����Ӵ����Ҳ���ӳ��󣬼�ӵ�������ϵͳʵ�ֵĸ��Ӷȡ�
 *    2.�����еĳ��󷽷�������ʵ�֣�����ִ�еĽ����Ӱ�츸��Ľ�����⵼��һ�ַ���Ŀ��ƽṹ��������˴����Ķ����Ѷȡ�
 *    3.���ڼ̳й�ϵ�����ȱ�㣬�����������µĳ��󷽷������������඼Ҫ��һ�顣
 *
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.TemplateMethod();
    }
}

//������
abstract class AbstractClass {
    //ģ�巽��
    public void TemplateMethod() {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    //���巽��
    public void SpecificMethod() {
        System.out.println("�������еľ��巽��������...");
    }

    //���󷽷�1
    public abstract void abstractMethod1();

    //���󷽷�2
    public abstract void abstractMethod2();
}

//��������
class ConcreteClass extends AbstractClass {
    public void abstractMethod1() {
        System.out.println("���󷽷�1��ʵ�ֱ�����...");
    }

    public void abstractMethod2() {
        System.out.println("���󷽷�2��ʵ�ֱ�����...");
    }
}

