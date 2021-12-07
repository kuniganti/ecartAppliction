package com.ecart.Dao;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecart.order.entity.LoginEntity;

public class LoginDao extends BaseDao {

	Logger LOGGER = LoggerFactory.getLogger(LoginDao.class);
	public LoginEntity validateUser(String userName){
		LoginEntity login = null;
		try{
			LOGGER.info("LoginDao EntityManager-----------"+em);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LoginEntity> cq = cb.createQuery(LoginEntity.class);
		Root<LoginEntity> a = cq.from(LoginEntity.class);
		Query q = em.createQuery(cq.select(a).where(cb.equal(a.get("userName"),userName))); 
		login = (LoginEntity) q.getSingleResult();
		}catch(EntityNotFoundException e){
			LOGGER.error("No record found for the user");
			throw e;
		}
		return login;
	}
}
