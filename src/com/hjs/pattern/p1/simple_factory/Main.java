package com.hjs.pattern.p1.simple_factory;

/**
 *        �򵥹���ģʽ����23�����һ�֣������֮��������һ��ר������ĳ����Ʒ���ࡣ 
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		GunFactory gunFactory = new GunFactory();
		Gun gun = gunFactory.getGun("ak47");
		gun.fire();
	}
}
