package com.cakeshop.model;

public class Help {

	private long phone;
	private String email;
	public double getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Help() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Help(long phone, String email) {
		super();
		this.phone = phone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Help [phone=" + phone + ", email=" + email + "]";
	}
	
	
	
	
	
	
}
