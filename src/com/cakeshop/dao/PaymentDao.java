package com.cakeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.cakeshop.model.Payment;
import com.cakeshop.model.User;

public class PaymentDao {
	
	public void insertPayment(Payment payment) {
		String insertQuery = "insert into payment_details(card_no,card_cvv,card_date,paid_amount) values(?,?,?,?)";

		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(insertQuery);
			pst.setLong(1, payment.getCardNo());
			pst.setInt(2, payment.getCardCvv());
			pst.setDate(3, new java.sql.Date(payment.getExpireDate().getTime()));
			pst.setInt(4, payment.getPaidAmount());
			pst.executeUpdate();
			System.out.println("your card details are saved successfully!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Value not inserted in the table");
		}

	}


}
