package com.hjs.pattern.p1.simple_factory;

public class GunRevolver implements Gun {

	@Override
	public void fire() {
		 System.out.println("firing with Revolver");
	}

}
