package com.my.evoucher.exception;

public class RecipientEmailExistException extends RuntimeException{

	public RecipientEmailExistException(){
		super("Email already exist ");
	}
}
