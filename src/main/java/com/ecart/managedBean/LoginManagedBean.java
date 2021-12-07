package com.ecart.managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecart.helpers.LoginHelper;
import com.ecart.order.View.LoginView;
import com.ecart.utils.WebContextUtil;

@ManagedBean(name="login")
public class LoginManagedBean implements Serializable{
	/**
	 * 
	 */
	
	Logger LOGGER = LoggerFactory.getLogger(LoginManagedBean.class);
	
	private static final long serialVersionUID = 1L;
	private LoginView loginView; 
	
	private LoginHelper loginHelper;
	public LoginManagedBean(){
		setLoginView(new LoginView());
		loginHelper = (LoginHelper) WebContextUtil.getBean("loginHelper");
	}
	
	
	public String validateUser(){
		String result= null;
		//System.out.println("userName = "+loginView.getUserName());
		//System.out.println("Password = "+loginView.getPassword());
		LOGGER.info("login helper"+loginHelper);
		//String result =loginHelper.validateUser(loginView.getUserName(), loginView.getPassword());
		
		UsernamePasswordToken token = new UsernamePasswordToken(loginView.getUserName(), loginView.getPassword(), null);
		Subject subject = SecurityUtils.getSubject();
		 result = "home";
		try{
			subject.login(token);
		}catch(AuthenticationException e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Credentials", null));
			result = "login";
		}
		return result;
		
	}

	public LoginHelper getLoginHelper() {
		return loginHelper;
	}

	public void setLoginHelper(LoginHelper loginHelper) {
		this.loginHelper = loginHelper;
	}
	
	public LoginView getLoginView() {
		return loginView;
	}
	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}
}
