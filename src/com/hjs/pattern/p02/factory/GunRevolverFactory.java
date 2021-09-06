package com.hjs.pattern.p02.factory;

public class GunRevolverFactory extends GunFactory{

	@Override
	public Gun getGun() {
		// TODO Auto-generated method stub
		return new GunRevolver();
	}

}
