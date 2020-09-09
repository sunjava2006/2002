package com.thzhima.myspring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public interface XiaoHong {

	Book byBook();
	
	public default String getBookName() {
		return this.byBook().getName();
	}
}
