package com.hjs.pattern.p10.decorator;

public class DecoratorPattern {
	/**
	 * 
	 * װ������Decorator��ģʽ�Ķ��壺ָ�ڲ��ı����ж���ṹ������£���̬�ظ��ö�������һЩְ�𣨼���������⹦�ܣ���ģʽ��
	 * �����ڶ���ṹ��ģʽ��
	 * 
	 * װ����ģʽ����Ҫ�ŵ��У� 
	 *    1.װ�����Ǽ̳е��������䣬�ȼ̳����ڲ��ı�ԭ�ж��������£���̬�ĸ�һ��������չ���ܣ����弴��
	 *    2.ͨ��ʹ�ò���װ���༰��Щװ�����������ϣ�����ʵ�ֲ�ͬЧ��
	 *    3.װ����ģʽ��ȫ���ؿ���ԭ��
	 *    
	 *ͨ������£���չһ����Ĺ��ܻ�ʹ�ü̳з�ʽ��ʵ�֡����̳о��о�̬��������϶ȸߣ�����������չ���ܵ����࣬���������͡�
	 *���ʹ����Ϲ�ϵ������һ����װ���󣨼�װ�ζ�����������ʵ���󣬲��ڱ�����ʵ�������ṹ�����ǰ���£�Ϊ���ṩ����Ĺ��ܣ�
	 *�����װ����ģʽ��Ŀ�ꡣ
	 *    
	 */
    public static void main(String[] args) {
        Component p = new ConcreteComponent();
        p.operation();
        System.out.println("---------------------------------");
        Component d = new ConcreteDecorator(p);
        d.operation();
    }
}
//���󹹼���ɫ
interface Component {
    public void operation();
}
//���幹����ɫ
class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("�������幹����ɫ");
    }
    public void operation() {
        System.out.println("���þ��幹����ɫ�ķ���operation()");
    }
}
//����װ�ν�ɫ
class Decorator implements Component {
    private Component component;
    public Decorator(Component component) {
        this.component = component;
    }
    public void operation() {
        component.operation();
    }
}
//����װ�ν�ɫ
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    public void operation() {
        super.operation();
        addedFunction();
    }
    public void addedFunction() {
        System.out.println("Ϊ���幹����ɫ���Ӷ���Ĺ���addedFunction()");
    }
}
