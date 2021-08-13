package com.hjs.pattern.p1.simple_factory;

/**
 *        简单工厂模式不是23种里的一种，简而言之，就是有一个专门生产某个产品的类。 
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		GunFactory gunFactory = new GunFactory();
		Gun gun = gunFactory.getGun("ak47");
		gun.fire();
	}
}
