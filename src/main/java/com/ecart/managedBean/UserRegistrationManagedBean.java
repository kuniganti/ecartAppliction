package com.ecart.managedBean;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ecart.helpers.UserHelper;
import com.ecart.order.View.UserView;
import com.ecart.order.entity.Address;
import com.ecart.order.entity.Contact;
import com.ecart.order.entity.Locality;
import com.ecart.order.entity.LoginEntity;
import com.ecart.order.entity.User;
import com.ecart.persistence.PersistenceEntityManager;
import com.ecart.services.UserService;
import com.ecart.utils.PasswordManager;
import com.ecart.utils.WebContextUtil;

@ManagedBean (name="userRegistration")
public class UserRegistrationManagedBean {

	private UserView userView;
	private PasswordManager passwordManager;
	private UserHelper usrHelper;
	
	
	public UserRegistrationManagedBean(){
		userView = new UserView();
		userView.setPrimaryContact(new Contact());
		userView.setSecondaryContact(new Contact());
		userView.setShippingAddress(new Address());
		userView.getShippingAddress().setLocality(new Locality());
		userView.setLogin(new LoginEntity()); 
		passwordManager = (PasswordManager) WebContextUtil.getBean("passwordManager");
		usrHelper = (UserHelper) WebContextUtil.getBean("userHelper");
		}
	
	public String addUser(){
		List<Contact> cntcts = new ArrayList<>();
		cntcts.add(userView.getPrimaryContact());
		cntcts.add(userView.getSecondaryContact());
		User user= new User(0,userView.getName(),cntcts);
		user.setGender(userView.getGender());
		user.setShippingaddress(userView.getShippingAddress());
		userView.getShippingAddress().setUser(user);
		String hashedPassword = passwordManager.encryptPasswordFromShiroDefaultPasswordService(userView.getLogin().getPassword());
		LoginEntity login = new LoginEntity(0, userView.getLogin().getUserName(),hashedPassword , 0, new Date());
		/*user.setLoginEntity(login);*/
		login.setUser(user);
		usrHelper.addUserAndLogin(login, user);
		//em.close();
		return "login";
	}

	public void validateEmailID(FacesContext context,
			UIComponent toValidate,
			Object value)throws ValidatorException{
		
		String emailID = (String) value;
		System.out.println(emailID);
		System.out.println(toValidate.getClientId());
		if(emailID.indexOf("@")==-1){
			System.out.println("No @ symbol");
			FacesMessage msg =new FacesMessage("Please provide valid emailID");
			FacesContext fc = FacesContext.getCurrentInstance();
			//UIComponent root = fc.getViewRoot();
			//UIComponent component = root.findComponent("unameId");
			fc.addMessage(toValidate.getClientId(fc), msg);
			throw new ValidatorException(msg);
		}
	}
	
	public UserView getUserView() {
		return userView;
	}

	public void setUserView(UserView userView) {
		this.userView = userView;
	}
	
	
}
