package com.cakeshop.model;

import java.util.Objects;

public class Cart {

	private int productId;
	private int userId;
	private int quantity;
	private double totalPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [productId=" + productId + ", userId=" + userId + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + "]";
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int productId, int userId, int quantity, double totalPrice) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

	
}