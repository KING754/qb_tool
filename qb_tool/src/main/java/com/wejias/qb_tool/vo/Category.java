package com.wejias.qb_tool.vo;

public class Category {
	private String name;
	private String savePath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", savePath=" + savePath + "]";
	}

}
