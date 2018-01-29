package com.poptok.admin.vo;

public class TagVo {
	
	private String tag;
	private int count;
	
	
	public TagVo() {
		
	}
	
	public TagVo(String tag, int count) {
		super();
		this.tag = tag;
		this.count = count;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
