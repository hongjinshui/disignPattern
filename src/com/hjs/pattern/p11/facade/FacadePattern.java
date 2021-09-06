package com.hjs.pattern.p11.facade;

public class FacadePattern {
	/**
	 * 
	 * ��ۣ�Facade��ģʽ�ֽ�������ģʽ����һ��ͨ��Ϊ������ӵ���ϵͳ�ṩһ��һ�µĽӿڣ���ʹ��Щ��ϵͳ�������ױ����ʵ�ģʽ��
	 * ��ģʽ������һ��ͳһ�ӿڣ��ⲿӦ�ó����ù����ڲ���ϵͳ�ľ���ϸ�ڣ��������󽵵�Ӧ�ó���ĸ��Ӷȣ�����˳���Ŀ�ά���ԡ�

     * ���ճ����빤���У����Ƕ�����������Ĵ���ʹ�����ģʽ��ֻҪ�Ǹ߲�ģ����Ҫ���ȶ����ϵͳ��2�����ϵ�����󣩣�
     * ���Ƕ����Ծ��ش���һ���µ����װ��Щ��ϵͳ���ṩ����Ľӿڣ��ø߲�ģ����Ը������׵ؼ�ӵ�����Щ��ϵͳ�Ĺ��ܡ�
     * �������ֽ׶θ��ֵ�����SDK����Դ��⣬�ܴ���ʶ���ʹ�����ģʽ��
     * 
     * ��ۣ�Facade��ģʽ�ǡ������ط��򡱵ĵ���Ӧ�ã�����������Ҫ�ŵ�:
     *   1.��������ϵͳ��ͻ���֮�����϶ȣ�ʹ����ϵͳ�ı仯����Ӱ��������Ŀͻ���;
     *   2.�Կͻ���������ϵͳ����������˿ͻ�����Ķ�����Ŀ����ʹ����ϵͳʹ��������������;
     *   3.�����˴������ϵͳ�еı��������ԣ�����ϵͳ�ڲ�ͬƽ̨֮�����ֲ���̣���Ϊ����һ����ϵͳ����Ӱ����������ϵͳ��Ҳ����Ӱ����۶���;
     *   
     * ��ۣ�Facade��ģʽ����Ҫȱ������:
     *   1.���ܺܺõ����ƿͻ�ʹ����ϵͳ�࣬�����״���δ֪����;
     *   2.�����µ���ϵͳ������Ҫ�޸�������ͻ��˵�Դ���룬Υ���ˡ�����ԭ��;
	 */
    public static void main(String[] args) {
        Facade f = new Facade();
        f.method();
    }
}
//��۽�ɫ
class Facade {
    private SubSystem01 obj1 = new SubSystem01();
    private SubSystem02 obj2 = new SubSystem02();
    private SubSystem03 obj3 = new SubSystem03();
    public void method() {
        obj1.method1();
        obj2.method2();
        obj3.method3();
    }
}
//��ϵͳ��ɫ
class SubSystem01 {
    public void method1() {
        System.out.println("��ϵͳ01��method1()�����ã�");
    }
}
//��ϵͳ��ɫ
class SubSystem02 {
    public void method2() {
        System.out.println("��ϵͳ02��method2()�����ã�");
    }
}
//��ϵͳ��ɫ
class SubSystem03 {
    public void method3() {
        System.out.println("��ϵͳ03��method3()�����ã�");
    }
}