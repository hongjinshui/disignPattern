package com.hjs.pattern.p02.factory;

public class GunAk47Factory extends GunFactory{

	@Override
	public Gun getGun() {
		// TODO Auto-generated method stub
		return new GunAk47();
	}

}
