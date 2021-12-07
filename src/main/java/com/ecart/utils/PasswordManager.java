package com.ecart.utils;

import org.apache.shiro.authc.credential.DefaultPasswordService;

public class PasswordManager {

	public static String encryptPasswordFromShiroDefaultPasswordService(String toBeEncryptedPassword){
		DefaultPasswordService passwordService = new DefaultPasswordService();
		return passwordService.encryptPassword(toBeEncryptedPassword);
	}
	
	public boolean authenticatePassword(String toBeAuthenPassword,String savedPassword){
		DefaultPasswordService passwordService = new DefaultPasswordService();
		return passwordService.passwordsMatch(toBeAuthenPassword, savedPassword);
	}
}
