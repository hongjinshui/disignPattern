package com.hjs.pattern.p3.abstract_factory;

public class RevolverFactory extends WeaponFactory{

	@Override
	public Gun getGun() {
		// TODO Auto-generated method stub
		return new GunRevolver();
	}

	@Override
	public Bullet getBullet() {
		// TODO Auto-generated method stub
		return new BulletRevolver();
	}

}
