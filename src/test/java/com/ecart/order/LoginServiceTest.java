package com.ecart.order;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ecart.Dao.ItemDao;
import com.ecart.helpers.LoginHelper;
import com.ecart.services.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:testApplicationContext.xml"})
public class LoginServiceTest {

	Logger LOGGER = null;
	@Autowired
	@Qualifier("loginService")
	LoginService login;
	
	@Autowired
	@Qualifier("loginHelper")
	LoginHelper loginHelper;
	
	@Autowired
	ItemDao itemDao;
	
	@Before
	public void init(){
		System.out.println("LoginServiceTest init ");
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResourceAsStream("log4j.properties"));
		 LOGGER = LoggerFactory.getLogger(LoginServiceTest.class);
	}
	
	@Test
	public void testLogin(){
		LOGGER.info("testLogin"+login);
		String result = login.getUserPasswordBasedonUserName("ckunganti", "prime");
		//LOGGER.info(result);
		LOGGER.info(result);
	}
	
	@Test
	public void testLoginHelper(){
		LOGGER.info("testLogin"+login);
		String result = loginHelper.validateUser("ckunganti", "prime");
		//LOGGER.info(result);
		LOGGER.info(result);
	}
	
	@Test
	public void testItemDaoInjection(){
		LOGGER.info("testItemDaoInjection"+itemDao);
	}
}
