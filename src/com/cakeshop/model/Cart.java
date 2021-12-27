package com.cakeshop.model;

import java.util.Date;
import java.util.Objects;

public class Cart {

	private int productId;
	private int userId;
	private int quantity;
	private double totalPrice;
	private Date orderDate;
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	public Cart(int productId, int userId, int quantity, double totalPrice, Date orderDate) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public String toString() {
		return  String.format("%-10s%-10s%-10s%-10s",productId,userId,quantity,totalPrice,orderDate+"\n");
	}

	
}