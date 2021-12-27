package com.cakeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRatingDao {
	public static void updateRating(int rating,int proId){
		String updateQuery="update product_details set rating=? where cake_id=?";
	
		Connection con=ConnectionUtil.getDbConnection();
		//System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1,rating);
			pstmt.setInt(2, proId);			
			pstmt.executeUpdate();
			System.out.println("Rating Updated successfully");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int findRating(String proName)
	{
		String findRating="select rating from product_details where cake_name='"+proName+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int rating=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findRating);
			if(rs.next())
			{
			rating=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rating;
		
	}

}


