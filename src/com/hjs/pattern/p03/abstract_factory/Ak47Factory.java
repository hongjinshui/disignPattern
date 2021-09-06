package com.hjs.pattern.p03.abstract_factory;

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
