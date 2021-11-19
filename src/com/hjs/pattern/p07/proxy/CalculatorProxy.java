package com.hjs.pattern.p07.proxy;

public class CalculatorProxy implements Calculator{

	private Calculator calculator;
	public CalculatorProxy() {
		this.calculator = new CalculatorImpl();
	}
	
	@Override
	public int add(int x, int y) {
		System.out.println("add方法通过静态代理执行");
		return calculator.add(x, y);
	}

	@Override
	public int subtract(int x, int y) {
		System.out.println("subtract方法通过静态代理执行");
		return calculator.subtract(x, y);
	}

}
