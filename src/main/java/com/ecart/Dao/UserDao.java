package com.ecart.Dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.order.entity.LoginEntity;
import com.ecart.order.entity.User;

public class UserDao extends BaseDao {

	Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
	@Transactional
	public LoginEntity persistUserAndLogin(LoginEntity login,User user){
		
		try{
			LOGGER.info("> persistUserAndLogin "+em);
			//em.getTransaction().begin();
			em.persist(user);
			em.persist(login);
			
			//em.flush();
			//em.getTransaction().commit();
		}catch(Exception e){
			LOGGER.error("error in inserting user details");
			throw e;
		}
		LOGGER.info("< persistUserAndLogin "+em);
		return login;
	}
}
