package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.utility.ConnectDB;

public class AdminDaoImp implements AdminDao
{
	Connection conn = ConnectDB.getConn();
	String sql;

	@Override
	public boolean adminLogin(String adminId, String adminPassword) 
	{
		try
		{	sql = "select * from AdminBank where AdminId=?";
		
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, adminId);
				ResultSet rs = psmt.executeQuery();
				while(rs.next())
				{
					if(adminId.equals(rs.getString("AdminId")) && adminPassword.equals(rs.getString("AdminPassword")))
					{	
						System.out.println("adminId=" +adminId + " adminPassword= "+ adminPassword);
						return true;
					}
					else
						return false;
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
