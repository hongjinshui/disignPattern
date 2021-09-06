package com.hjs.pattern.p06.prototype;

public class Client {

	public Prototype operation(Prototype example) {
		return example.clone();
	}
}
