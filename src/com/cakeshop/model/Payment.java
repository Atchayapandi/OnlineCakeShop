package com.cakeshop.model;

import java.util.Date;

public class Payment {

	private long cardNo;
	
	private Date expireDate;
	private int paidAmount;
	
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public int getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(long cardNo, Date expireDate, int paidAmount) {
		super();
		this.cardNo = cardNo;
		
		this.expireDate = expireDate;
		this.paidAmount = paidAmount;
	}
	@Override
	public String toString() {
		return "Payment [cardNo=" + cardNo +  ", expireDate=" + expireDate + ", paidAmount="
				+ paidAmount + "]";
	}
}
	