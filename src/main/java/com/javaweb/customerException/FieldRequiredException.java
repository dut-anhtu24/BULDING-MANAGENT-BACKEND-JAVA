package com.javaweb.customerException;

public class FieldRequiredException extends RuntimeException {
	
	public FieldRequiredException(String s) {
		super(s);
	}
}
