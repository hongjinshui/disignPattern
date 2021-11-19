package com.hjs.pattern.p07.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��̬����
 * @author Administrator
 *
 */
public class MainDynamic {

	/**
	 * ����ģʽ�Ķ��壺����ĳЩԭ����Ҫ��ĳ�����ṩһ�������Կ��ƶԸö���ķ��ʡ���ʱ�����ʶ����ʺϻ��߲���ֱ������Ŀ�����
	 * ���������Ϊ���ʶ����Ŀ�����֮����н顣
	 * 
	 * ����ģʽ����Ҫ�ŵ��У�
            1.����ģʽ�ڿͻ�����Ŀ�����֮����һ���н����úͱ���Ŀ���������ã�
            2.������������չĿ�����Ĺ��ܣ�
            3.����ģʽ�ܽ��ͻ�����Ŀ�������룬��һ���̶��Ͻ�����ϵͳ����϶ȣ������˳���Ŀ���չ��

    ���ݴ���Ĵ���ʱ�ڣ�����ģʽ��Ϊ��̬����Ͷ�̬����

    ��̬���ɳ���Ա������������ض������Զ�����Դ�����ٶ�����룬�ڳ�������ǰ������� .class �ļ����Ѿ������ˡ�
    ��̬���ڳ�������ʱ�����÷�����ƶ�̬��������
    
     *
	 */
	public static void main(String[] args) throws Exception {
		Calculator target = new CalculatorImpl();
		//Calculator calculatorProxy = (Calculator) getProxy(target);
		ProxyHandler handler = new ProxyHandler();
		Calculator calculatorProxy = (Calculator)handler.newProxyInstance(target);
		calculatorProxy.add(1,2);
		calculatorProxy.subtract(2,1);
	}
	
	private static Object getProxy(final Object target) throws Exception {
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),//�������
				target.getClass().getInterfaces(),//�ô�������Ŀ�����ʵ����ͬ�ӿ�
				new InvocationHandler(){//�������ķ������ն��ᱻJVM��������invoke����
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(method.getName() + "������ʼִ��...");
						Object result = method.invoke(target, args);
						System.out.println(result);
						System.out.println(method.getName() + "����ִ�н���...");
						return result;
					}
				}
		);
	}
	
}
