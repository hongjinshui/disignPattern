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
 *      抽象工厂模式也就是同一工厂不仅生产枪，同时生产子弹。  也就是武器厂商是个父类，有生产枪，生产子弹两个接口。  
 *  AK47工厂，Revolver工厂继承它，可以分别生产Ak47枪+Ak47子弹，和Revolver枪+Revolver子弹。 
 *       创建工厂时，决定了能生产那种枪和子弹。
 *       枪和子弹属于一系列的产品，产品之间存在紧密联系。枪必须搭配子弹才能用，而且Ak47的枪只能用Ak47的子弹。
 * 
 *
 * 【工厂方法模式】： 一个抽象产品类，可以派生出多个具体产品类。一个抽象工厂类，可以派生出多个具体工厂类。
 * 每个具体工厂类只能创建一个具体产品类的实例。 
 * 【抽象工厂模式】： 多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。 一个抽象工厂类，可以派生出多个具体工厂类。
 * 每个具体工厂类可以创建多个具体产品类的实例。 区别： 工厂方法模式只有一个抽象产品类，而抽象工厂模式有多个。 
 * 工厂方法模式的具体工厂类只能创建一个具体产品类的实例，而抽象工厂模式可以创建多个。
 */
public class Main {

	public static void main(String[] args) {
		WeaponFactory weaponFactory = new Ak47Factory();
		Shooter shooter = new Shooter();
		shooter.prepareWeapon(weaponFactory);
		shooter.shoot();
	}
}
