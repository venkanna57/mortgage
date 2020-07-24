package com.db.training.mortgage.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String s) {
		super(s);
	}
}
