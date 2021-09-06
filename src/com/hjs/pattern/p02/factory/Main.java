package com.hjs.pattern.p2.factory;

class Shooter{
	private Gun gun;
	public void buyGun(GunFactory gunFactory) {
		this.gun = gunFactory.getGun();
	}
	
	public void shoot() {
		if(gun == null) {
			System.out.println("you need to buy a gun from a gun factory");
		} else {
			gun.fire();
		}
	}
}

/**
 * ��������ģʽҲ����ǹ�����Ǹ����࣬������ǹ����ӿڡ�
  Ak47ǹ������Revolverǹ�����̳��������Էֱ�����Ak47ǹ��Revolverǹ��
   ��������ǹ�����ɲ������������Ǵ���ǹ����ʱ�����ĸ����������ġ�
   ����ֱ�ӵ���ǹ����.����ǹ()���ɡ�
  �������һ��ǹ����Ҫ����һ��ǹ��ʵ�����ǹ���������࣬�����øĹ�������߼���
  ������ѭ�˿���ԭ�򣨶���չ���ţ����޸Ĺرգ�
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		GunFactory gunFactory = new GunAk47Factory();
		Shooter shooter = new Shooter();
		shooter.buyGun(gunFactory);
		shooter.shoot();
	}
}
