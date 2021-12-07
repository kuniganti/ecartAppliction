package com.ecart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ecart.Dao.UserDao;
import com.ecart.order.entity.LoginEntity;
import com.ecart.order.entity.User;

public class UserService {
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	public void addUser(LoginEntity login , User user){
		userDao.persistUserAndLogin(login, user);


	}
}
