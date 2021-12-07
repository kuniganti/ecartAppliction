package com.ecart.Dao;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.order.entity.Category;
import com.ecart.order.entity.Item;

@Component
public class ItemDao extends BaseDao {

	Logger LOGGER = LoggerFactory.getLogger(ItemDao.class);
	
	public Item getItemBasedOnID(Long itemID){
		Item item = null;
		try{
			LOGGER.info("ItemDao EntityManager-----------"+em);
			LOGGER.info("getItemBasedOnID -----------"+itemID);
		Query query = em.createQuery("select i from "+Item.class.getName()+" i where i.itemID =:itemID");
		query.setParameter("itemID", itemID);
		item = (Item) query.getSingleResult();
		}catch(Exception e){
			LOGGER.error("No record found for the item");
			e.printStackTrace();
			throw e;
		}
		return item;
	}
	
	@Transactional
	public void insertIntoCategory(Category category){
		
		try{
			LOGGER.info("ItemDao EntityManager-----------"+em);
			LOGGER.info("ItemDao tobe inserted Item----------"+category);
			em.persist(category);
		}catch(Exception e){
			LOGGER.error("unable to insert into the item item");
			throw e;
		}
	}
	
	@Transactional
	public void insertIntoItem(Item item){
		
		try{
			LOGGER.info("ItemDao EntityManager-----------"+em);
			LOGGER.info("ItemDao tobe inserted Item----------"+item);
			em.persist(item);
		}catch(Exception e){
			LOGGER.error("unable to insert into the item item");
			throw e;
		}
	}
}
