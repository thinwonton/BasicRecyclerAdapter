package com.github.thinwonton.basicrecycleradapter.sample.model;

/**
 * Created by Administrator on 2016/4/19.
 */
public class Cat {
	private int index;
	private String name;
	private int type;

	public Cat(int index, String name, int type) {
		this.index = index;
		this.name = name;
		this.type = type;
	}

	public enum TYPE {
		TYPE1, TYPE2
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
