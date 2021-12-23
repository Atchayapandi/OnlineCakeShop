package com.cakeshop.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Invoice {
	private int productId;
	private int userId;
	private int cartId;
	private double finalPrice;
	private Date orderDate;

	

	@Override
	public String toString() {
		return "Invoice productId=" + productId + ", /nuserId=" + userId + ",/ncartId=" + cartId + ", /nfinalPrice="
				+ finalPrice  ;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	public Invoice(int productId, int userId, int cartId, double finalPrice, Timestamp orderDate) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.cartId = cartId;
		this.finalPrice = finalPrice;
		
	}
	
	
	
}

