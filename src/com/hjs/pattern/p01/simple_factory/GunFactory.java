package com.hjs.pattern.p01.simple_factory;

public class GunFactory {

	public Gun getGun(String gun) {
		switch(gun) {
		case "ak47":
			return new GunAk47();
		case "revolver":
			return new GunRevolver();
		default:
			return null;
		}
	}
}
