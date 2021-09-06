package com.hjs.pattern.p02.factory;

public class GunRevolver implements Gun {

	@Override
	public void fire() {
		 System.out.println("firing with Revolver");
	}

}
