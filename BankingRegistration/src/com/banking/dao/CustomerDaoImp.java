package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.pojo.Customer;
import com.banking.utility.ConnectDB;

public class CustomerDaoImp implements CustomerDao
{
	Connection conn = ConnectDB.getConn();
	String sql=null;
	@Override
	public boolean addCustomer(Customer c) 
	{
		sql = "insert into CustomerBank values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, c.getCustName());
				psmt.setString(2, c.getCustDOB());
				psmt.setString(3, c.getCustPhNo());
				psmt.setString(4, c.getCustEmail());
				psmt.setString(5, c.getCustAadhar());
				psmt.setString(6, c.getCustPAN());
				psmt.setString(7, c.getCustAddress());
				psmt.setString(8, c.getCustAccNo());
				psmt.setString(9, c.getCustId());
				psmt.setString(10, c.getCustPassword());
				psmt.setString(11, c.getCustTranPassword());
				
				int i= psmt.executeUpdate();
				if(i>0)
					return true;
				else
					return false;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) 
	{
		sql="update CustomerBank set CustomerPhNo=?, CustomerEmail=?, CustomerAddress=?, CustomerPassword=?, CustomerTranPassword=? where CustomerId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, c.getCustPhNo());
			psmt.setString(2, c.getCustEmail());
			psmt.setString(3, c.getCustAddress());
			psmt.setString(4, c.getCustPassword());
			psmt.setString(5, c.getCustTranPassword());
			psmt.setString(6, c.getCustId());
			int i = psmt.executeUpdate();
			if(i > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean customerLogin(String custId, String custPassword) 
	{
		sql = "select CustomerId, CustomerPassword from CustomerBank where CustomerId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				if(custId.equals(rs.getString("CustomerId")) && custPassword.equals(rs.getString("CustomerPassword")))
					return true;
				else
					return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteCustomer(String custId) 
	{
		sql="delete from CustomerBank where CustomerId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			
			int i = psmt.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer searchCustomerById(String custId) 
	{
		Customer c = new Customer();
		sql = "select * from CustomerBank where CustomerId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				c.setCustName(rs.getString("CustomerName"));
				c.setCustDOB(rs.getString("CustomerDOB"));
				c.setCustPhNo(rs.getString("CustomerPhNo"));
				c.setCustEmail(rs.getString("CustomerEmail"));
				c.setCustAadhar(rs.getString("CustomerAadhar"));
				c.setCustPAN(rs.getString("CustomerPAN"));
				c.setCustAddress(rs.getString("CustomerAddress"));
				c.setCustAccNo(rs.getString("CustomerAccNo"));
				c.setCustId(rs.getString("CustomerId"));
				c.setCustPassword(rs.getString("CustomerPassword"));
				c.setCustTranPassword(rs.getString("CustomerTranPassword"));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> displayAllCustomer() 
	{
		List<Customer> custList = new ArrayList<Customer>();
		sql = "select * from CustomerBank";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustName(rs.getString("CustomerName"));
				c.setCustDOB(rs.getString("CustomerDOB"));
				c.setCustPhNo(rs.getString("CustomerPhNo"));
				c.setCustEmail(rs.getString("CustomerEmail"));
				c.setCustAadhar(rs.getString("CustomerAadhar"));
				c.setCustPAN(rs.getString("CustomerPAN"));
				c.setCustAddress(rs.getString("CustomerAddress"));
				c.setCustAccNo(rs.getString("CustomerAccNo"));
				c.setCustId(rs.getString("CustomerId"));
				c.setCustPassword(rs.getString("CustomerPassword"));
				c.setCustTranPassword(rs.getString("CustomerTranPassword"));
				custList.add(c);
			}
			return custList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
