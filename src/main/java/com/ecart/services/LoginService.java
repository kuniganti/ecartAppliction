package com.ecart.services;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ecart.Dao.LoginDao;
import com.ecart.order.entity.LoginEntity;
@Component
public class LoginService {

	Logger LOGGER = (Logger) LoggerFactory.getLogger(LoginService.class);
	
	private LoginEntity login;
	@Autowired
	@Qualifier("loginDao")
	private LoginDao loginDao;

	public LoginEntity getLogin() {
		return login;
	}

	public void setLogin(LoginEntity login) {
		this.login = login;
	}
	
	public String getUserPasswordBasedonUserName(String userName,String password){
		String result= null;
		try{
		//EntityManager em = PersistenceEntityManager.getEntityManager();
			LOGGER.info("LoginDao object in getUserPasswordBasedonUserName {}",loginDao);
		login = loginDao.validateUser(userName);
		if(login.getPassword().equals(password)){
			LOGGER.info("Login was success");
			result = "home";
		}else{
			LOGGER.info("Login was Failure");
			result = "login";
		}
		}catch(NoResultException exp){
			LOGGER.info("UserName/Password combination does not exist");
			exp.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
}
