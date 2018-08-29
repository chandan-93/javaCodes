package com.foodplaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectivity {
	
	static Connection conn = null;
	
	public static Connection getDBConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chandan","root","myRootPass");
			return conn;
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
