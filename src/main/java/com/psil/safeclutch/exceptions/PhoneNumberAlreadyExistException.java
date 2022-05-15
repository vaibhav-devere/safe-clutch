package com.psil.safeclutch.exceptions;

public class PhoneNumberAlreadyExistException extends RuntimeException {

	/**
	 * @author vdevere
	 */
	private static final long serialVersionUID = 1L;
	public PhoneNumberAlreadyExistException(final String msg) {
		super(msg);
	}

}