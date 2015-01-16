package com.flyingh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PageOpenFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("PageOpenFilter.doFilter()");
		if (App.getSemaphore().tryAcquire()) {
			System.out.println("current available:" + App.getSemaphore().availablePermits());
			chain.doFilter(request, response);
		} else {
			response.getWriter().write("<h1>more than 3 windows,not available</h1>");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
