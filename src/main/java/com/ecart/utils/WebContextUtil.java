package com.ecart.utils;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.jsf.FacesContextUtils;


public class WebContextUtil {
	Logger LOGGER = LoggerFactory.getLogger(WebContextUtil.class);
	private WebContextUtil(){
		
	}
	
	public static Object getBean(String beanName){
		Object bean= null; 
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		if(ctx != null){
			bean = ctx.getBean(beanName);
		}
		return bean;
	}
	
	public static Object getCollaboratorForRest(String beanName) {

		if (!StringUtils.hasLength(beanName)) {
			return null;
		}
		ApplicationContext ctx = SpringApplicationContextProvider
				.getApplicationContext();
		if (null == ctx) {
			return null;
		} else {
			return ctx.getBean(beanName);
		}
	}
}
