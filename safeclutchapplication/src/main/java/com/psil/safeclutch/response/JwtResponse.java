package com.psil.safeclutch.response;

/**
 * 
 * @author vpottumu
 *
 */
public class JwtResponse {
	
	private Long userId;
	private String userFirstName;
	private String userLastName;
	private Long userPhoneNumber;
	private String jwtToken;
		

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	
	public JwtResponse(Long userId, String userFirstName, String userLastName, Long userPhoneNumber, String jwtToken) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPhoneNumber = userPhoneNumber;
		this.jwtToken = jwtToken;
	}

	public JwtResponse() {
		super();
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Long getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(Long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	
	
}