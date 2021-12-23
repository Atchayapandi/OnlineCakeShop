package com.cakeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cakeshop.model.Cart;
import com.cakeshop.model.Invoice;
import com.cakeshop.model.Products;
import com.cakeshop.model.User;

public class InvoiceDao {
	public void insertInvoice(Invoice invoice)
	{
		
		String insert="INSERT INTO INVOICE_DETAILS(cake_id,user_id,cart_id,final_price,order_date) VALUES(?,?,?,?,?)";
		
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement(insert);
			pst.setInt(1,invoice.getProductId());
			pst.setInt(2, invoice.getUserId());
			pst.setInt(3, invoice.getCartId());
			pst.setDouble(4, invoice.getFinalPrice());
			
			pst.executeUpdate();
			System.out.println("Value inserted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Value not inserted in the table");
		}

		
	}
	
//view invoice items
	
	public List<Invoice> viewInvoice(User currentUser) {
		
		
		List<Invoice> userInvoiceList = new ArrayList<Invoice>();
		String query = "select * from cart_items";
		Connection con = ConnectionUtil.getDbConnection();	
		ProductDao productDao = new ProductDao();		
		
	
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				
				
				userInvoiceList.add(new Invoice(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5),rs.getTimestamp(6)));			
		   
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userInvoiceList;
	}
	
	

	

}
