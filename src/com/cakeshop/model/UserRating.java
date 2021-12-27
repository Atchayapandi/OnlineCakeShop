package com.cakeshop.model;

public class UserRating {
	
	private String ProductName;
	private int ProName;
	private int rating;
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProName() {
		return ProName;
	}
	public void setProName(int proName) {
		ProName = proName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public UserRating(String productName, int proName, int rating) {
		super();
		ProductName = productName;
		ProName = proName;
		this.rating = rating;
	}
	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRating [ProductName=" + ProductName + ", ProName=" + ProName + ", rating=" + rating + "]";
	}
	
	
	
	
	
	

}
