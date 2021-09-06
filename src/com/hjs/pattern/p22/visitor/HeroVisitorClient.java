package com.hjs.pattern.p22.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式定义：封装一些作用于某种数据结构中的各元素的操作，它可以在不改变这个数据结构的前提下，定义作用于这些元素的新操作。
 * 
 * 如何来理解呢？举个例子来说吧，假如我们都玩过王者荣耀。每个英雄都有三个基本的技能，但是不同的玩家操作英雄技能实现的方式是不一样的。
 * 比如说你玩韩信只能送人头，梦泪玩韩信那就是百战百胜。
 * 
 * 此例中在不改变英雄技能的前提下，不同的玩家可以有不同的操作
 */
public class HeroVisitorClient {
	public static void main(String[] args) {
		ObjectStruct os = new ObjectStruct();
		Hero zhuang = new ZhuangHero();
		Hero zhen = new ZhenHero();
		os.addHero(zhuang);
		os.addHero(zhen);
		Player visitorMe = new PlayerMe();
		Player visitorOthers = new PlayerOthers();
		// 让访问者访问对象结构中的元素
		os.handleRequest(visitorMe);
		os.handleRequest(visitorOthers);
	}
}

abstract class Hero {
	// 英雄可以接受玩家的访问，让玩家来操作
	public abstract void accept(Player visitor);
}

//甄姬
class ZhenHero extends Hero {
	// 可以接受玩家的操作
	@Override
	public void accept(Player visitor) {
		visitor.visitZhen(this);
	}

	// 自身的技能
	public void operateA() {
		System.out.println("甄姬放出了技能A");
	}
	
	// 自身的技能
	public void operateB() {
		System.out.println("甄姬放出了技能B");
	}
}

//庄周
class ZhuangHero extends Hero {
	// 接受外部的访问
	@Override
	public void accept(Player visitor) {
		visitor.visitZhuang(this);
	}

	// 自身的技能
	public void operateA() {
		System.out.println("庄周放出了技能A");
	}
	
	// 自身的技能
	public void operateB() {
		System.out.println("庄周放出了技能B");
	}
}

//玩家可以访问甄姬和庄周的技能
interface Player {
	public abstract void visitZhuang(ZhuangHero element);

	public abstract void visitZhen(ZhenHero element);
}

class PlayerMe implements Player {
	@Override
	public void visitZhuang(ZhuangHero element) {
		System.out.println("玩家我访问庄周，庄周开始使出技能");
		element.operateA();
		element.operateB();
	}

	@Override
	public void visitZhen(ZhenHero element) {
		System.out.println("玩家我访问甄姬，甄姬开始使出技能");
		element.operateA();
		element.operateB();
	}
}

class PlayerOthers implements Player {
	@Override
	public void visitZhuang(ZhuangHero element) {
		System.out.println("玩家其他人访问庄周，庄周开始使出技能");
		element.operateA();
	}

	@Override
	public void visitZhen(ZhenHero element) {
		System.out.println("玩家其他人访问甄姬，甄姬开始使出技能");
		element.operateA();
	}
}

class ObjectStruct {
	// 保存所有需要被访问的元素
	private List<Hero> heros = new ArrayList<Hero>();

	public void handleRequest(Player visitor) {
		// 访问所有元素
		for (Hero hero : heros) {
			hero.accept(visitor);
		}
	}

	public void addHero(Hero hero) {
		heros.add(hero);
	}
}