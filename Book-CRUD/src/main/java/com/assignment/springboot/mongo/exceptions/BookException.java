package com.assignment.springboot.mongo.exceptions;

public class BookException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BookException(String msg) {
		super(msg);
	}
}
