package com.ecart.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ecart.order.entity.LoginEntity;
import com.ecart.order.entity.User;
import com.ecart.services.UserService;

public class UserHelper {
	@Autowired
	@Qualifier("userService")
	private UserService usrService;
	
	public void addUserAndLogin(LoginEntity login , User user){
		usrService.addUser(login, user);
	}
}
