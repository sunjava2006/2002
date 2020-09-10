package com.thzhima.jw.beans;

import org.springframework.beans.factory.annotation.Value;

public class PageBean {

	private int page = 1;
	
	private int size;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
