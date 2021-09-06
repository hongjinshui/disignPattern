package com.hjs.pattern.p01.simple_factory;

public class GunRevolver implements Gun {

	@Override
	public void fire() {
		 System.out.println("firing with Revolver");
	}

}
