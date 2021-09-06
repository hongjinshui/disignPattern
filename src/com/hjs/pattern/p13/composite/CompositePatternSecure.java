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
public class CompositePatternSecure {
	/**
	 *   (2) ��ȫ��ʽ
	 *   �ڸ÷�ʽ�У��������ӹ����ķ����Ƶ���֦�����У����󹹼�����Ҷ����û�ж��Ӷ���Ĺ������������ͱ�������һ�ַ�ʽ�İ�ȫ�����⣬
	 *   ������Ҷ�Ӻͷ�֧�в�ͬ�Ľӿڣ��ͻ����ڵ���ʱҪ֪����Ҷ�������֦����Ĵ��ڣ�����ʧȥ��͸���ԡ�
	 * 
	 */
    public static void main(String[] args) {
    	CompositeSecure c0 = new CompositeSecure();
    	CompositeSecure c1 = new CompositeSecure();
        ComponentSecure leaf1 = new LeafSecure("1");
        ComponentSecure leaf2 = new LeafSecure("2");
        ComponentSecure leaf3 = new LeafSecure("3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}
//���󹹼�
interface ComponentSecure {
    public void operation();
}
//��Ҷ����
class LeafSecure implements ComponentSecure {
    private String name;
    public LeafSecure(String name) {
        this.name = name;
    }
    public void add(ComponentSecure c) {
    }
    public void remove(ComponentSecure c) {
    }
    public ComponentSecure getChild(int i) {
        return null;
    }
    public void operation() {
        System.out.println("��Ҷ" + name + "�������ʣ�");
    }
}
//��֦����
class CompositeSecure implements ComponentSecure {
    private ArrayList<ComponentSecure> children = new ArrayList<ComponentSecure>();
    public void add(ComponentSecure c) {
        children.add(c);
    }
    public void remove(ComponentSecure c) {
        children.remove(c);
    }
    public ComponentSecure getChild(int i) {
        return children.get(i);
    }
    public void operation() {
        for (Object obj : children) {
            ((ComponentSecure) obj).operation();
        }
    }
}
