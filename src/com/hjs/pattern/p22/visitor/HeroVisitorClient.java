package com.hjs.pattern.p22.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ������ģʽ���壺��װһЩ������ĳ�����ݽṹ�еĸ�Ԫ�صĲ������������ڲ��ı�������ݽṹ��ǰ���£�������������ЩԪ�ص��²�����
 * 
 * ���������أ��ٸ�������˵�ɣ��������Ƕ����������ҫ��ÿ��Ӣ�۶������������ļ��ܣ����ǲ�ͬ����Ҳ���Ӣ�ۼ���ʵ�ֵķ�ʽ�ǲ�һ���ġ�
 * ����˵���溫��ֻ������ͷ�������溫���Ǿ��ǰ�ս��ʤ��
 * 
 * �������ڲ��ı�Ӣ�ۼ��ܵ�ǰ���£���ͬ����ҿ����в�ͬ�Ĳ���
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
		// �÷����߷��ʶ���ṹ�е�Ԫ��
		os.handleRequest(visitorMe);
		os.handleRequest(visitorOthers);
	}
}

abstract class Hero {
	// Ӣ�ۿ��Խ�����ҵķ��ʣ������������
	public abstract void accept(Player visitor);
}

//�缧
class ZhenHero extends Hero {
	// ���Խ�����ҵĲ���
	@Override
	public void accept(Player visitor) {
		visitor.visitZhen(this);
	}

	// ����ļ���
	public void operateA() {
		System.out.println("�缧�ų��˼���A");
	}
	
	// ����ļ���
	public void operateB() {
		System.out.println("�缧�ų��˼���B");
	}
}

//ׯ��
class ZhuangHero extends Hero {
	// �����ⲿ�ķ���
	@Override
	public void accept(Player visitor) {
		visitor.visitZhuang(this);
	}

	// ����ļ���
	public void operateA() {
		System.out.println("ׯ�ܷų��˼���A");
	}
	
	// ����ļ���
	public void operateB() {
		System.out.println("ׯ�ܷų��˼���B");
	}
}

//��ҿ��Է����缧��ׯ�ܵļ���
interface Player {
	public abstract void visitZhuang(ZhuangHero element);

	public abstract void visitZhen(ZhenHero element);
}

class PlayerMe implements Player {
	@Override
	public void visitZhuang(ZhuangHero element) {
		System.out.println("����ҷ���ׯ�ܣ�ׯ�ܿ�ʼʹ������");
		element.operateA();
		element.operateB();
	}

	@Override
	public void visitZhen(ZhenHero element) {
		System.out.println("����ҷ����缧���缧��ʼʹ������");
		element.operateA();
		element.operateB();
	}
}

class PlayerOthers implements Player {
	@Override
	public void visitZhuang(ZhuangHero element) {
		System.out.println("��������˷���ׯ�ܣ�ׯ�ܿ�ʼʹ������");
		element.operateA();
	}

	@Override
	public void visitZhen(ZhenHero element) {
		System.out.println("��������˷����缧���缧��ʼʹ������");
		element.operateA();
	}
}

class ObjectStruct {
	// ����������Ҫ�����ʵ�Ԫ��
	private List<Hero> heros = new ArrayList<Hero>();

	public void handleRequest(Player visitor) {
		// ��������Ԫ��
		for (Hero hero : heros) {
			hero.accept(visitor);
		}
	}

	public void addHero(Hero hero) {
		heros.add(hero);
	}
}