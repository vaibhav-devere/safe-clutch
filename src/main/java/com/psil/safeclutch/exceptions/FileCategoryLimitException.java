package com.psil.safeclutch.exceptions;

public class FileCategoryLimitException extends RuntimeException{

	public FileCategoryLimitException(final String msg) {
		super(msg);
	}
}
