package com.thzhima.jw.configurations;

import org.springframework.core.convert.converter.Converter;

public class NullString implements Converter<String, String>{

	@Override
	public String convert(String source) {
		if("null".equals(source)) {
			return null;
		}else {
			return source;
		}

	}

}
