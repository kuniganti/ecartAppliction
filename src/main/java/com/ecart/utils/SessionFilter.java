package com.ecart.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFilter implements Filter {

	Logger LOGGER = LoggerFactory.getLogger(SessionFilter.class);
	
	@Override
	public void destroy() {
		LOGGER.info("inside SessionFilter Destroy method");
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		LOGGER.info("inside SessionFilter doFilter method");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String requestURI = request.getRequestURI();
		Subject subject = SecurityUtils.getSubject();
		
		if(subject.isAuthenticated()){
			filterChain.doFilter(servletRequest, servletResponse);
		}else {
			if (requestURI.indexOf("/login.xhtml")>0){
				filterChain.doFilter(servletRequest, servletResponse);
			}else{
				
				String home = request.getRequestURL().substring(0,request.getRequestURL().indexOf(request.getServletPath()));
				
				LOGGER.info(home+"/index.jsp");
				response.sendRedirect(home+"/index.jsp"); 
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("inside SessionFilter init method");
		
	}

}
