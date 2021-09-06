package com.hjs.pattern.p03.abstract_factory;

class Shooter{
	
	private Gun gun;
	private Bullet bullet;
	
	private void buyGun(WeaponFactory weaponFactory) {
		this.gun = weaponFactory.getGun();
	}
	
	private void buyBullet(WeaponFactory weaponFactory) {
		this.bullet = weaponFactory.getBullet();
	}
	
	public void prepareWeapon(WeaponFactory weaponFactory) {
		buyGun(weaponFactory);
		buyBullet(weaponFactory);
	}
	
	public void shoot() {
		if(gun == null) {
			System.out.println("you need to buy a gun");
		} else if(bullet == null) {
			System.out.println("you need to buy some bullets");
		}	else {
			gun.fire();
			bullet.getOutOfGun();
		}
	}
}

/**
 *      ���󹤳�ģʽҲ����ͬһ������������ǹ��ͬʱ�����ӵ���  Ҳ�������������Ǹ����࣬������ǹ�������ӵ������ӿڡ�  
 *  AK47������Revolver�����̳��������Էֱ�����Ak47ǹ+Ak47�ӵ�����Revolverǹ+Revolver�ӵ��� 
 *       ��������ʱ������������������ǹ���ӵ���
 *       ǹ���ӵ�����һϵ�еĲ�Ʒ����Ʒ֮����ڽ�����ϵ��ǹ��������ӵ������ã�����Ak47��ǹֻ����Ak47���ӵ���
 * 
 *
 * ����������ģʽ���� һ�������Ʒ�࣬������������������Ʒ�ࡣһ�����󹤳��࣬����������������幤���ࡣ
 * ÿ�����幤����ֻ�ܴ���һ�������Ʒ���ʵ���� 
 * �����󹤳�ģʽ���� ��������Ʒ�࣬ÿ�������Ʒ�������������������Ʒ�ࡣ һ�����󹤳��࣬����������������幤���ࡣ
 * ÿ�����幤������Դ�����������Ʒ���ʵ���� ���� ��������ģʽֻ��һ�������Ʒ�࣬�����󹤳�ģʽ�ж���� 
 * ��������ģʽ�ľ��幤����ֻ�ܴ���һ�������Ʒ���ʵ���������󹤳�ģʽ���Դ��������
 */
public class Main {

	public static void main(String[] args) {
		WeaponFactory weaponFactory = new Ak47Factory();
		Shooter shooter = new Shooter();
		shooter.prepareWeapon(weaponFactory);
		shooter.shoot();
	}
}
