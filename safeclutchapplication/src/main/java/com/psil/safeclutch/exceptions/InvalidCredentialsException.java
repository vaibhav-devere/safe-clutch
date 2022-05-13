package com.psil.safeclutch.exceptions;

public class InvalidCredentialsException extends RuntimeException {

	/**
	 * for invalid credentials
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException(String message) {
		super(message);
	}

}
