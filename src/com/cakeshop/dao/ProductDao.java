package com.cakeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cakeshop.model.Products;
import com.cakeshop.model.User;

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
				Products product = new Products(rs.getString(2), rs.getString(3),Integer.parseInt(rs.getString(4)),	rs.getString(5));
				productsList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productsList;
	}

//add new product
	
	public void insertProduct(Products product) {
		String insertQuery = "insert into user_details(cake_name,cake_description,cake_price,category_name) values(?,?,?,?)";

		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, product.getCakeName());
			pst.setString(2, product.getCakeDescription());
			pst.setInt(3, product.getCakePrice());
			pst.setString(4, product.getCategoryName());
			pst.executeUpdate();
			System.out.println("Value inserted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Value not inserted in the table");
		}

	}
	
	
	
//update product
	public static void updateProduct(String updateProduct) {
		String updateQuery = "update product_details set cake_name =?  where cake_id=?";

		try {
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		pstmt.setString(1, updateProduct.split(",")[0]);
		pstmt.setInt(2, Integer.parseInt(updateProduct.split(",")[1]));
		int i = pstmt.executeUpdate();
		System.out.println(i + "row updated");
		pstmt.close();
		con.close();
		}catch(SQLException e) {
			System.out.println("incorrect");
			e.printStackTrace();
		}
		
	}
	
//rating insert 
	public static void insertRating(int insertRating) {
		
		String updateQuery="update product_details set Ratings=? where cake_name=?";
		
		Connection con=ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(updateQuery);
//			pstmt.setInt(1, Integer.parseInt(insertRating.split(",")[1]));
//			pstmt.setString(2, Products.getCakeName());
			pstmt.executeUpdate();
			System.out.println("Rating  added thank you!!");
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
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
				System.out.println(price);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return price;
		
	}
	
	public List<Products> findCategory(String categoryName) {
		List<Products> categoryList = new ArrayList<Products>();
 
		Products category=null;
		String showQuery = "select * from product_details where category_name='"+categoryName+"'";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			while(rs.next()) {
				 category = new Products(rs.getString(2),rs.getString(3),rs.getInt(4),categoryName);
				categoryList.add(category);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryList;
	}
}
