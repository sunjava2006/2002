package com.thzhima.jw.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class GeneralSetCharsetFilter implements Filter {
	String charset = null;
	
	public void init(FilterConfig config) throws ServletException {
		this.charset = config.getInitParameter("charset");
	}
	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, 
			             ServletResponse response, 
			             FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.charset);
		System.out.println("---before doFilter-----------------");
		chain.doFilter(request, response);
		System.out.println("---after doFilter-----------------");
	}

	
	

}
