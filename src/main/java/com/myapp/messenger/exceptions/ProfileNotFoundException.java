package com.myapp.messenger.exceptions;

public class ProfileNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public ProfileNotFoundException() {
		super();
	}

	public ProfileNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProfileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProfileNotFoundException(String message) {
		super(message);
	}

	public ProfileNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
