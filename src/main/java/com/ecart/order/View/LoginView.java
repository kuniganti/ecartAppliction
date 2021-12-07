package com.ecart.order.View;

import java.util.Date;

public class LoginView {
	private long loginId;
	private String userName;
	private String password;
	private int roleID;
	private Date lastLoginDate;
	
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
	public LoginView(long loginId, String userName, String password, int roleID, Date lastLoginDate) {
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.roleID = roleID;
		this.lastLoginDate = lastLoginDate;
	}
	public LoginView() {
	}
	@Override
	public String toString() {
		return "LoginView [loginId=" + loginId + ", userName=" + userName + ", roleID=" + roleID + ", lastLoginDate="
				+ lastLoginDate + "]";
	}
	
	
}
