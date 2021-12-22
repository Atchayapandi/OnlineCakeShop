package com.cakeshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cakeshop.model.User;



public class AdminDao {

	public static User validateAdmin (String emailId,String password) {
		
		String validateQuery="select*from user_details where role='Admin'and Email_id='" +emailId +"'and password='"+password+"'";
		Connection con=ConnectionUtil.getDbConnection();
		User user=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(validateQuery);
			
			if(rs.next()) {
				user=new User(rs.getString(2),emailId,password,rs.getString(5));
			}
			
		}
		catch(SQLException e) {
			
		}
		return user;
		
	}
		
		
		
	
}
