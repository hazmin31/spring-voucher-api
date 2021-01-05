package com.my.evoucher.exception;

public class VoucherExpiredException extends RuntimeException {
	public VoucherExpiredException() {
		super("Voucher has expired.");
	}
}
