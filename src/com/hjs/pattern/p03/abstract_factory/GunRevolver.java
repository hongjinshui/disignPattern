package com.hjs.pattern.p03.abstract_factory;

public class GunRevolver implements Gun {

	@Override
	public void fire() {
		 System.out.println("firing with Revolver");
	}

}
