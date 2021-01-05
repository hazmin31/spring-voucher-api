package com.my.evoucher.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Recipient {

	@Id private String id;
	
	private String name;
	
	@Indexed(unique=true)
	private String email;
	
	public Recipient (String name, String email) {
		this.name = name;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Recipient [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
