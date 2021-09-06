package com.hjs.pattern.p3.abstract_factory;

public class Ak47Factory extends WeaponFactory{

	@Override
	public Gun getGun() {
		// TODO Auto-generated method stub
		return new GunAk47();
	}

	@Override
	public Bullet getBullet() {
		// TODO Auto-generated method stub
		return new BulletAk47();
	}

}
