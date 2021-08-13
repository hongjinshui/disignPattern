package com.hjs.pattern.p6.prototype;

public class Client {

	public Prototype operation(Prototype example) {
		return example.clone();
	}
}
