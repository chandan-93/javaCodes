package com.banking.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB 
{
	static Connection conn=null;

	public static Connection getConn() 
	{	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost:3306/bankingdb?useSSL=false";
			
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingdb","root","myRootPass");
			
			conn = DriverManager.getConnection(connURL,"root","myRootPass");
			return conn;
			
		} catch (Exception e) 
			{
				e.printStackTrace();
			}
		
		return null;
	}
}
