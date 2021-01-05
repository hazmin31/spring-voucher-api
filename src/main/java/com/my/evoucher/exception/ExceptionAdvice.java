package com.my.evoucher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(RecipientEmailExistException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	String recipientEmailExist(RecipientEmailExistException e) {
		return e.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(RecipientNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String recipientNotFound(RecipientNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(VoucherAlreadyUsedException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	String voucherAlreadyUsed(VoucherAlreadyUsedException e) {
		return e.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(VoucherNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String vouchertNotFound(VoucherNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(VoucherExpiredException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	String voucherExpired(VoucherExpiredException e) {
		return e.getMessage();
	}
	
	
}
