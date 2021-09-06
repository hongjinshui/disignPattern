package com.hjs.pattern.p22.visitor;
import java.util.*;

/**
 * �����ߣ�Visitor��ģʽ�Ķ��壺��������ĳ�����ݽṹ�еĸ�Ԫ�صĲ������������װ�ɶ������࣬
 * ʹ���ڲ��ı����ݽṹ��ǰ���¿��������������ЩԪ�ص��µĲ�����Ϊ���ݽṹ�е�ÿ��Ԫ���ṩ���ַ��ʷ�ʽ��
 * ���������ݵĲ��������ݽṹ���з��룬����Ϊ��ģʽ����ӵ�һ��ģʽ��
 *
 * �����ߣ�Visitor��ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ����¡�
 *     1.��չ�Ժá��ܹ��ڲ��޸Ķ���ṹ�е�Ԫ�ص�����£�Ϊ����ṹ�е�Ԫ������µĹ��ܡ�
 *     2.�����Ժá�����ͨ����������������������ṹͨ�õĹ��ܣ��Ӷ����ϵͳ�ĸ��ó̶ȡ�
 *     3.����Ժá�������ģʽ�����ݽṹ�������ڽṹ�ϵĲ������ʹ�ò������Ͽ�������ɵ��ݻ�����Ӱ��ϵͳ�����ݽṹ��
 *     4.���ϵ�һְ��ԭ�򡣷�����ģʽ����ص���Ϊ��װ��һ�𣬹���һ�������ߣ�ʹÿһ�������ߵĹ��ܶ��Ƚϵ�һ��
 * 
 * �����ߣ�Visitor��ģʽ����Ҫȱ�����¡�
 *     1.�����µ�Ԫ��������ѡ��ڷ�����ģʽ�У�ÿ����һ���µ�Ԫ���࣬��Ҫ��ÿһ���������������������Ӧ�ľ����������Υ���ˡ�����ԭ�򡱡�
 *     2.�ƻ���װ��������ģʽ�о���Ԫ�ضԷ����߹���ϸ�ڣ����ƻ��˶���ķ�װ�ԡ�
 *     3.Υ������������ԭ�򡣷�����ģʽ�����˾����࣬��û�����������ࡣ
 *
 */
public class VisitorPattern {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor = new ConcreteVisitorB();
        os.accept(visitor);
    }
}

//���������
interface Visitor {
    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}

//���������A��
class ConcreteVisitorA implements Visitor {
    public void visit(ConcreteElementA element) {
        System.out.println("���������A����-->" + element.operationA());
    }

    public void visit(ConcreteElementB element) {
        System.out.println("���������A����-->" + element.operationB());
    }
}

//���������B��
class ConcreteVisitorB implements Visitor {
    public void visit(ConcreteElementA element) {
        System.out.println("���������B����-->" + element.operationA());
    }

    public void visit(ConcreteElementB element) {
        System.out.println("���������B����-->" + element.operationB());
    }
}

//����Ԫ����
interface Element {
    void accept(Visitor visitor);
}

//����Ԫ��A��
class ConcreteElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "����Ԫ��A�Ĳ�����";
    }
}

//����Ԫ��B��
class ConcreteElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "����Ԫ��B�Ĳ�����";
    }
}

//����ṹ��ɫ
class ObjectStructure {
    private List<Element> list = new ArrayList<Element>();

    public void accept(Visitor visitor) {
        Iterator<Element> i = list.iterator();
        while (i.hasNext()) {
            ((Element) i.next()).accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}

