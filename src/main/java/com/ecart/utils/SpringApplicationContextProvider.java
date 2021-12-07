package com.ecart.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContextProvider implements ApplicationContextAware {

	private static ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
		System.out.println("which we got from spring "+applicationContext);
	}
	
	public static ApplicationContext getApplicationContext(){
		System.out.println("*************** "+ctx);
		return ctx;
	}

}
