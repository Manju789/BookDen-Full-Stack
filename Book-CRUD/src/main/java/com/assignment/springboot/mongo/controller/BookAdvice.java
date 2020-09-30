package com.assignment.springboot.mongo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.springboot.mongo.exceptions.BookException;

@RestControllerAdvice
public class BookAdvice {
	@ExceptionHandler(value = {BookException.class})
	
	public ResponseEntity<String> ExceptionWhenBookIdIsPresent(BookException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
