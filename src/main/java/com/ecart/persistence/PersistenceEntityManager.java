package com.ecart.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PersistenceEntityManager {
	private static EntityManager em;
	
	static{
		em = Persistence.createEntityManagerFactory("eCartPersistance").createEntityManager();
	}
	
	public static EntityManager getEntityManager(){
		return em;
		
	}
}
