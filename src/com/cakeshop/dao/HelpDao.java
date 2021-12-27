package com.cakeshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cakeshop.model.Help;


public class HelpDao {

	public Help showHelp() {
		
       
		String showQuery = "select * from help_support";
		Connection con = ConnectionUtil.getDbConnection();
		Help help=null;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			if (rs.next()) {
				 help = new Help(rs.getLong(1), rs.getString(2));			
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return help;
	}
	
	
	
	
	
}
