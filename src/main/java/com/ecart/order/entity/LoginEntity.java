package com.ecart.order.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LoginEntity {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long loginId;
	private String userName;
	private String password;
	private int roleID;
	private Date lastLoginDate;
	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(unique=true,name="userID")
	private User user;
	
	public long getLoginId() {
		return loginId;
	}
	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public LoginEntity(long loginId, String userName, String password, int roleID, Date lastLoginDate) {
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.roleID = roleID;
		this.lastLoginDate = lastLoginDate;
	}
	public LoginEntity() {
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "LoginEntity [loginId=" + loginId + ", userName=" + userName + ", roleID=" + roleID + ", lastLoginDate="
				+ lastLoginDate + "]";
	}
	
	
}
