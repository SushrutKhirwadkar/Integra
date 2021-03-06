package com.soch.Integra.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UrlRewriteFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		  HttpServletRequest request = (HttpServletRequest) req;
	        String requestURI = request.getRequestURI();
	        if (!requestURI.contains("/services")) {
	        	request.getRequestDispatcher("index.html");
	        	chain.doFilter(req, res);
	        	
	        } else {
	            chain.doFilter(req, res);
	        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
