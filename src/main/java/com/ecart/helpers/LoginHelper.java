package com.ecart.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ecart.services.LoginService;

public class LoginHelper {

	Logger LOGGER = (Logger) LoggerFactory.getLogger(LoginHelper.class);
	
	@Autowired
	@Qualifier("loginService")
	LoginService login;
	
	public String validateUser(String userName,String password){
		LOGGER.info("login service in login helper {}",login);
		String result = login.getUserPasswordBasedonUserName(userName, password);
		
		return result;
	}

	public LoginService getLogin() {
		return login;
	}

	public void setLogin(LoginService login) {
		this.login = login;
	}
	
	
}
