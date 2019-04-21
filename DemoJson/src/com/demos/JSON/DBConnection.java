package com.demos.JSON;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
	}catch(ClassNotFoundException e){
		e.printStackTrace();
		}
	}
	
	static ResultSet executeSQLQuery(String sql){
		ResultSet rs = null;
	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_user_test", "root", "sandip007");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}