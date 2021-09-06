package com.hjs.pattern.p6.prototype;

public class ConcretePrototype implements Prototype{

	private String id;
	private String name;
	
	@Override
	public String toString() {
		return "ConcretePrototype [id=" + id + ", name=" + name + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ¹¹ÔìÆ÷
	 * @param id
	 * @param name
	 */
	public ConcretePrototype(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Prototype clone() {
		try {
			return (Prototype)super.clone();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
