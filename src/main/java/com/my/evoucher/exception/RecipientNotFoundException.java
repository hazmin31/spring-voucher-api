package com.my.evoucher.exception;

public class RecipientNotFoundException extends RuntimeException {
	
	public RecipientNotFoundException () {
		super("Recipient Not Found");
	}

}
