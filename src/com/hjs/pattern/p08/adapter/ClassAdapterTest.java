package com.hjs.pattern.p08.adapter;

//Ŀ��ӿ�
interface Target {
	public void request();
}

//�����߽ӿ�
class Adaptee {
	public void specificRequest() {
		System.out.println("�������е�ҵ����뱻���ã�");
	}
}

//����������
class ClassAdapter extends Adaptee implements Target {
	public void request() {
		specificRequest();
	}
}

//�ͻ��˴���
public class ClassAdapterTest {
	/**
	 * ������ģʽ��Adapter���Ķ������£���һ����Ľӿ�ת���ɿͻ�ϣ��������һ���ӿڣ�
	 * ʹ��ԭ�����ڽӿڲ����ݶ�����һ��������Щ����һ������������ģʽ��Ϊ��ṹ��ģʽ�Ͷ���ṹ��ģʽ���֣�
	 * ǰ����֮�����϶ȱȺ��߸ߣ���Ҫ�����Ա�˽�����������е����������ڲ��ṹ������Ӧ����Խ���Щ��
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("��������ģʽ���ԣ�");
		Target target = new ClassAdapter();
		target.request();
	}
}