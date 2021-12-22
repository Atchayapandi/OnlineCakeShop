package com.cakeshop.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Invoice {

	private Products product;
	private User user;
	private Cart cart;
	private double finalPrice;
	private Timestamp orderDate;
	
	
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(Products product, User user, Cart cart, double finalPrice, Timestamp orderDate) {
		super();
		this.product = product;
		this.user = user;
		this.cart = cart;
		this.finalPrice = finalPrice;
		this.orderDate = orderDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cart, finalPrice, orderDate, product, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(cart, other.cart)
				&& Double.doubleToLongBits(finalPrice) == Double.doubleToLongBits(other.finalPrice)
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(product, other.product)
				&& Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "Invoice [product=" + product + ", user=" + user + ", cart=" + cart + ", finalPrice=" + finalPrice
				+ ", orderDate=" + orderDate + "]";
	}
	
	
	
	
	

}

