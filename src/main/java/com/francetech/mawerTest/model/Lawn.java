package com.francetech.mawerTest.model;

import java.util.ArrayList;
import java.util.List;

public class Lawn {
	
	private int height;
	private int width;
	
	private List<Mower> mowerList = new ArrayList<>();
	
	public Lawn() {
		super();
	}
	
	
	public Lawn(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}


	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}


	public List<Mower> getMowerList() {
		return mowerList;
	}


	public void setMowerList(List<Mower> mowerList) {
		this.mowerList = mowerList;
	}
	
	

}
