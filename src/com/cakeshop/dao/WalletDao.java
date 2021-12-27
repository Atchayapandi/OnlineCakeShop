package com.cakeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WalletDao {

	//get wallet balance:
	public static int walletbal(int id) throws Exception 
	{
		Connection con = ConnectionUtil.getDbConnection();
		String query = "select user_wallet from user_details where user_id = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
				return rs.getInt(1);
		}
		return -1;
	}

//update wallet balance:
	public int updatewallet(int amount,int userid)throws Exception {
		Connection con = ConnectionUtil.getDbConnection();
		String query = "update user_details set user_wallet = ? where user_id = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1,amount);
		statement.setInt(2, userid);
		int res = statement.executeUpdate();
		 statement.executeUpdate("commit");
		return res;	

	}
	
	
}
