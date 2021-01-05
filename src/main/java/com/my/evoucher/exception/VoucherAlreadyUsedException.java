package com.my.evoucher.exception;

public class VoucherAlreadyUsedException extends RuntimeException {
	
	public VoucherAlreadyUsedException() {
		super("Voucher have been used.");
	}

}
