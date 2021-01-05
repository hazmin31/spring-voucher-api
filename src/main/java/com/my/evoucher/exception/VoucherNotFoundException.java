package com.my.evoucher.exception;

public class VoucherNotFoundException extends RuntimeException {

	public VoucherNotFoundException() {
		super("Voucher not found.");
	}
}
