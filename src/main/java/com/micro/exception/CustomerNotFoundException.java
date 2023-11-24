package com.micro.exception;

public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 9139964045667828175L;
	public CustomerNotFoundException() {
		super();
	}
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
