package com.hjs.pattern.p13.composite;

import java.util.ArrayList;

/**
 * ��ϣ�Composite Pattern��ģʽ�Ķ��壺��ʱ�ֽ�������-���֣�Part-Whole��ģʽ������һ�ֽ�������ϳ���״�Ĳ�νṹ��ģʽ��
 * ������ʾ������-���֡��Ĺ�ϵ��ʹ�û��Ե����������϶������һ�µķ����ԣ����ڽṹ�����ģʽ��
 * 
 * ���ģʽһ���������������벿�ֵĹ�ϵ������������֯�����νṹ�У�����Ľڵ㱻��Ϊ���ڵ㣬���ڵ�������԰�����֦�ڵ��Ҷ�ӽڵ㣬
 * ��֦�ڵ������ֿ��԰�����֦�ڵ��Ҷ�ӽڵ㡣
 * 
 * ��ʵ���ڵ����֦�ڵ㱾��������ͬһ���������ͣ�������Ϊ����ʹ�ã���Ҷ�ӽڵ�����֦�ڵ��������ϲ�������һ�����͡�
 * ���������ģʽ�У������֦�ڵ��Ҷ�ӽڵ㿴������ͬһ���������ͣ���ͳһ�ӿڶ��壩�������Ǿ߱�һ����Ϊ��
 * �����������ģʽ�У��������νṹ�еĶ�������ͬһ�����ͣ������ĺô������û�����Ҫ�������֦�ڵ㻹��Ҷ�ӽڵ㣬
 * ����ֱ�ӽ��в��������û���ʹ�ô�������ı�����
 * 
 * ���ģʽ����Ҫ�ŵ��У� 
 *   1.���ģʽʹ�ÿͻ��˴������һ�µش������������϶�����������Լ�������ǵ������󣬻�����϶�������˿ͻ��˴��룻
 *   2.��������������ڼ����µĶ��󣬿ͻ��˲�����Ϊ�������µĶ��������Դ���룬���㡰����ԭ�򡱣�
 *  
 * ����Ҫȱ���ǣ� 
 *   1.��ƽϸ��ӣ��ͻ�����Ҫ������ʱ��������֮��Ĳ�ι�ϵ��
 *   2.���������������еĹ�����
 *   3.�������ü̳еķ��������ӹ������¹��ܣ�
 *   
 * ���ģʽ��Ϊ͸��ʽ�����ģʽ�Ͱ�ȫʽ�����ģʽ��
 * 
 */
public class CompositePattern {
	/**
	 *  (1) ͸����ʽ
	 *  �ڸ÷�ʽ�У����ڳ��󹹼����������������е�ȫ�����������Կͻ�������������Ҷ�������֦���󣬶Կͻ�����˵��͸���ġ�
	 *  ����ȱ���ǣ���Ҷ��������û�� Add()��Remove() �� GetChild() ������ȴҪʵ�����ǣ���ʵ�ֻ����쳣�������������һЩ��ȫ�����⡣
	 * 
	 */
    public static void main(String[] args) {
        Component c0 = new Composite();
        Component c1 = new Composite();
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}
//���󹹼�
interface Component {
    public void add(Component c);
    public void remove(Component c);
    public Component getChild(int i);
    public void operation();
}
//��Ҷ����
class Leaf implements Component {
    private String name;
    public Leaf(String name) {
        this.name = name;
    }
    public void add(Component c) {
    }
    public void remove(Component c) {
    }
    public Component getChild(int i) {
        return null;
    }
    public void operation() {
        System.out.println("��Ҷ" + name + "�������ʣ�");
    }
}
//��֦����
class Composite implements Component {
    private ArrayList<Component> children = new ArrayList<Component>();
    public void add(Component c) {
        children.add(c);
    }
    public void remove(Component c) {
        children.remove(c);
    }
    public Component getChild(int i) {
        return children.get(i);
    }
    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}
