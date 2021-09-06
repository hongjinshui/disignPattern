package com.hjs.pattern.p08.adapter;

//������������
class ObjectAdapter implements Target {
	
	private Adaptee adaptee;

	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	public void request() {
		adaptee.specificRequest();
	}
}

//�ͻ��˴���
public class ObjectAdapterTest {
	/**
	 * ������ģʽ��Adapter���Ķ������£���һ����Ľӿ�ת���ɿͻ�ϣ��������һ���ӿڣ�
	 * ʹ��ԭ�����ڽӿڲ����ݶ�����һ��������Щ����һ������������ģʽ��Ϊ��ṹ��ģʽ�Ͷ���ṹ��ģʽ���֣�
	 * ǰ����֮�����϶ȱȺ��߸ߣ���Ҫ�����Ա�˽�����������е����������ڲ��ṹ������Ӧ����Խ���Щ��
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("����������ģʽ���ԣ�");
		Adaptee adaptee = new Adaptee();
		Target target = new ObjectAdapter(adaptee);
		target.request();
	}
}
