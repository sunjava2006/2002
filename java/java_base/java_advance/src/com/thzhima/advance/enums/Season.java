package com.thzhima.advance.enums;

public enum Season {
	SPRING(1,3,"春天来了"),
	SUMMER(4,6,"夏天到了"),
	AUTUMN(7,9,"瓜果熟了"),
	WINTER(10,12,"什么都没有了");
	
	private int startMonth;
	private int endMonth;
	private String msg;

	private Season(int start, int end, String msg) {
		this.startMonth = start;
		this.endMonth = end;
		this.msg = msg;
	}
	
	private Season() {
		
	}
	
	public int getStartMonth() {
		return this.startMonth;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}
	
	public String toString() {
		return super.toString() + this.msg;
	}
}
