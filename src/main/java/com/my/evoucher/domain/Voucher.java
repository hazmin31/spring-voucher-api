package com.my.evoucher.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Voucher {
	
	@Id private String id;
	
	@Indexed(unique=true)
	private String code;
	private Recipient recipient;
	private  SpecialOffer specialOffer;
	
	private Date expirationDate;
	private Date dateOfUsage;
	
	public Voucher(String code, Recipient recipient, SpecialOffer specialOffer, Date expirationDate, Date dateOfUsage) {
		super();
		this.code = code;
		this.recipient = recipient;
		this.specialOffer = specialOffer;
		this.expirationDate = expirationDate;
		this.dateOfUsage = dateOfUsage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}
	public SpecialOffer getSpecialOffer() {
		return specialOffer;
	}
	public void setSpecialOffer(SpecialOffer specialOffer) {
		this.specialOffer = specialOffer;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getDateOfUsage() {
		return dateOfUsage;
	}
	public void setDateOfUsage(Date dateOfUsage) {
		this.dateOfUsage = dateOfUsage;
	}

	@Override
	public String toString() {
		return "Voucher [id=" + id + ", recipient=" + recipient + ", specialOffer=" + specialOffer + ", expirationDate="
				+ expirationDate + ", dateOfUsage=" + dateOfUsage + "]";
	}
}

