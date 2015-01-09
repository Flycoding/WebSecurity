package com.flyingh.filter;

import java.io.IOException;

import javax.script.ScriptException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.flyingh.util.Base64Util;

public class UrlFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		if (!"GET".equals(req.getMethod())) {
			chain.doFilter(request, response);
			return;
		}
		req.setCharacterEncoding("UTF-8");
		String queryString = req.getQueryString();
		System.out.println(queryString);
		try {
			if (queryString != null) {
				String real = Base64Util.decode(queryString);
				System.out.println(real);
				req.getRequestDispatcher(req.getRequestURI().substring(req.getContextPath().length()) + "?" + real).forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		} catch (ScriptException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void destroy() {
	}

}
