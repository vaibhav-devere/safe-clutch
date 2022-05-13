package com.psil.safeclutch.request;
/**
 * 
 * @author vpottumu
 *
 */
public class JwtRequest {

	private String userEmail;
	private String password;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
