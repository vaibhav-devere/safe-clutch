package com.psil.safeclutch.exceptions;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("unused")
public class EmailAlreadyExistException extends RuntimeException {

	/**
	 * @author vdevere
	 */
	private static final long serialVersionUID = 1L;
	public EmailAlreadyExistException(final String msg) {
		super(msg);
	}

}
