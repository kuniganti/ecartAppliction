package com.ecart.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecart.Dao.ItemDao;
import com.ecart.order.entity.Category;
import com.ecart.order.entity.Item;
import com.ecart.utils.WebContextUtil;
@Component
@Path("rest/ecart/Item")
public class ItemRestService {
	
	Logger LOGGER = LoggerFactory.getLogger(ItemRestService.class);
	
	@Autowired
	ItemDao itemDao;
	
	@Path("/test")
	@GET
	@Consumes(MediaType.TEXT_HTML)
	public Response itemRestServiceTest(){
		itemDao = (ItemDao) WebContextUtil.getCollaboratorForRest("itemDao");
		LOGGER.info("Rest Item service is up and running...."+itemDao);
		String result = "Rest Item service is up and running....";
		return Response.status(Status.OK).entity(result).build();
	}
	
	@Path("/getItemWithID")
	@GET
	@Consumes(MediaType.APPLICATION_JSON )
	@Produces(MediaType.APPLICATION_JSON )
	public ItemRestBean getItemBasedOnID(@QueryParam("ItemID") String itemID){
		Long itemIDL = Long.valueOf(itemID);
		LOGGER.info("got GET request to rest SERVICE ItemRestService for ItemID"+itemID);
		itemDao = (ItemDao) WebContextUtil.getCollaboratorForRest("itemDao");
		LOGGER.info("itemDao in getItemBasedOnID"+itemDao);
		Item item = itemDao.getItemBasedOnID(itemIDL);
		ItemRestBean itemRestBeanResult = new ItemRestBean();
		itemRestBeanResult.setName(item.getName());
		itemRestBeanResult.setPrice(String.valueOf(item.getPrice()));
		itemRestBeanResult.setSeller(item.getSeller());
		return itemRestBeanResult;
		
	}
	
	@Path("/insertItem")
	@POST
	@Consumes(MediaType.APPLICATION_JSON )
	public Response insertItem(ItemRestBean itemRestBean){
		Item item = new Item();
		Category category = new Category();
		item.setName(itemRestBean.getName());
		item.setPrice(Double.valueOf(itemRestBean.getPrice()) );
		item.setSeller(itemRestBean.getSeller());
		category.setName(itemRestBean.getCategory().getName());
		itemDao = (ItemDao) WebContextUtil.getCollaboratorForRest("itemDao");
		LOGGER.info("itemDao in insertItem"+itemDao);
		itemDao.insertIntoCategory(category);
		item.setCategory(category);
		LOGGER.info("got GET request to rest SERVICE ItemRestService for ItemID"+item);
		
		itemDao.insertIntoItem(item);
		return Response.status(Status.OK).entity("Item got inserted").build();
		
	}
}
