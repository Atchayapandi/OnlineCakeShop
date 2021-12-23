package com.cakeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cakeshop.model.Products;

public class ProductDao {

	ConnectionUtil conUtil = new ConnectionUtil();
	Connection con = conUtil.getDbConnection();

//show product method

	public List<Products> showProduct() {
		List<Products> productsList = new ArrayList<Products>();

		String showQuery = "select * from product_details";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			while (rs.next()) {
				Products product = new Products(rs.getString(2), rs.getString(3),Integer.parseInt(rs.getString(4)),
						rs.getString(5));
				productsList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productsList;
	}

//update product
	public static void updateProduct(String updateProduct) throws ClassNotFoundException, SQLException {
		String updateQuery = "update product_details set cake_name =?  where cake_id=?";

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		pstmt.setString(1, updateProduct.split(",")[0]);
		pstmt.setInt(2, Integer.parseInt(updateProduct.split(",")[1]));
		int i = pstmt.executeUpdate();
		System.out.println(i + "row updated");
		pstmt.close();
		con.close();
	}

//delete method
	
	public static void deleteProduct(String delete) throws ClassNotFoundException, SQLException {
		String deleteQuery = "delete from product_details where cake_id=?";

		Connection con = ConnectionUtil.getDbConnection();
		//System.out.println("Connection successfully");
		PreparedStatement pstmt = con.prepareStatement(deleteQuery);
		pstmt.setInt(1, Integer.parseInt(delete));
		int i = pstmt.executeUpdate();
		System.out.println(i + "row deleted");
		pstmt.close();
		con.close();
	}
	
//find product id	
	
	public static int findProductId1(String productName)
	{
		String query="select cake_id from product_details where cake_name='"+productName+"'";
		
		Connection con=ConnectionUtil.getDbConnection();
	    Statement stmt; 
		int proId=0;
		try {
			stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				proId=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return proId;
		
	}
	

	public  int findPrice(int proID)
	{
		String query="select cake_price from product_details where cake_id='"+proID+"'";
		
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int price=0;
		try {
			stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				price=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return price;
		
	}
	
	public List<Products> findCategory(String categoryName) {
		List<Products> categoryList = new ArrayList<Products>();
 
		String category=null;
		String showQuery = "select * from product_details where category_name='"+categoryName+"'";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			if(rs.next()) {
				 category = rs.getString(2);
				//categoryList.add(category);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryList;
	}
}
