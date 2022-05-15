package com.psil.safeclutch.exceptions;

/**
 * @author vdevere
 *
 */
public class FileNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public FileNotFoundException(final String msg) {
		super(msg);
	}
}
