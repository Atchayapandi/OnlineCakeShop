package com.cakeshop.model;

import java.util.Date;

public class Payment {

	private int cardNo;
	private int cardCvv;
	private Date expireDate;
	private int paidAmount;
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public int getCardCvv() {
		return cardCvv;
	}
	public void setCardCvv(int cardCvv) {
		this.cardCvv = cardCvv;
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
	public Payment(int cardNo, int cardCvv, Date expireDate, int paidAmount) {
		super();
		this.cardNo = cardNo;
		this.cardCvv = cardCvv;
		this.expireDate = expireDate;
		this.paidAmount = paidAmount;
	}
	@Override
	public String toString() {
		return "Payment [cardNo=" + cardNo + ", cardCvv=" + cardCvv + ", expireDate=" + expireDate + ", paidAmount="
				+ paidAmount + "]";
	}
}
	