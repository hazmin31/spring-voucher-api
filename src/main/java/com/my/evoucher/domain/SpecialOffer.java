package com.my.evoucher.domain;

import org.springframework.data.annotation.Id;

public class SpecialOffer {
	
	@Id private String id;
	
	private String name;
	private double percentage;
	
	public SpecialOffer(String name, double percentage) {
		this.name = name;
		this.percentage = percentage;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "SpecialOffer [id=" + id + ", name=" + name + ", percentage=" + percentage + "]";
	}
	

}
