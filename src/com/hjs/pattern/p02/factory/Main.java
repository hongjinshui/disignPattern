package com.hjs.pattern.p2.factory;

class Shooter{
	private Gun gun;
	public void buyGun(GunFactory gunFactory) {
		this.gun = gunFactory.getGun();
	}
	
	public void shoot() {
		if(gun == null) {
			System.out.println("you need to buy a gun from a gun factory");
		} else {
			gun.fire();
		}
	}
}

/**
 * 工厂方法模式也就是枪工厂是个父类，有生产枪这个接口。
  Ak47枪工厂，Revolver枪工厂继承它，可以分别生产Ak47枪，Revolver枪。
   生产哪种枪不再由参数决定，而是创建枪工厂时，由哪个工厂决定的。
   后续直接调用枪工厂.生产枪()即可。
  如果新增一种枪，需要新增一个枪的实现类和枪工厂的子类，而不用改工厂类的逻辑。
  这样遵循了开闭原则（对扩展开放，对修改关闭）
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		GunFactory gunFactory = new GunAk47Factory();
		Shooter shooter = new Shooter();
		shooter.buyGun(gunFactory);
		shooter.shoot();
	}
}
