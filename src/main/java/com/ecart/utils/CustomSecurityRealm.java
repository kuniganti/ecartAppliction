package com.ecart.utils;

import javax.sql.DataSource;

import org.apache.shiro.realm.jdbc.JdbcRealm;

public class CustomSecurityRealm extends JdbcRealm {

	public CustomSecurityRealm(){
		super();
		DataSource ds = (DataSource) WebContextUtil.getCollaboratorForRest("dataSource");
		super.setDataSource(ds);
	}
}
