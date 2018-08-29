package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.pojo.AccountDetails;
import com.banking.utility.ConnectDB;

public class AccountDetailsDaoImp implements AccountDetailsDao
{
	Connection conn = ConnectDB.getConn();
	AccountDetails ad = new AccountDetails();
	String sql = null;
	@Override
	public boolean addAccount(AccountDetails ad) 
	{
		sql = "insert into AccountBank values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, ad.getCustId());
			psmt.setString(2, ad.getCustName());
			psmt.setString(3, ad.getCustAccNo());
			psmt.setDouble(4, ad.getCustBalance());
			psmt.setString(5, ad.getBank());
			psmt.setString(6, ad.getBranch());
			psmt.setString(7, ad.getIFSC());
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
	public AccountDetails myAccount(String custId) 
	{
		sql="select * from AccountBank where CustomerId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				ad.setCustId(rs.getString("CustomerId"));
				ad.setCustName(rs.getString("CustomerName"));
				ad.setCustAccNo(rs.getString("CustomerAccNo"));
				ad.setCustBalance(rs.getDouble("CustomerBalance"));
				ad.setBank(rs.getString("Bank"));
				ad.setBranch(rs.getString("Branch"));
				ad.setIFSC(rs.getString("IFSC"));
			}
			return ad;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean deleteAccount(String custAccNo)
	{
		sql = "delete from AccountBank where CustomerAccNo=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custAccNo);
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
	public AccountDetails searchAccountByAccNo(String custAccNo)
	{
		String sql="select * from AccountBank where CustomerAccNo=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custAccNo);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				ad.setCustId(rs.getString("CustomerId"));
				ad.setCustName(rs.getString("CustomerName"));
				ad.setCustAccNo(rs.getString("CustomerAccNo"));
				ad.setCustBalance(rs.getDouble("CustomerBalance"));
				ad.setBank(rs.getString("Bank"));
				ad.setBranch(rs.getString("Branch"));
				ad.setIFSC(rs.getString("IFSC"));
			}
			return ad;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<AccountDetails> displayAllAccounts() 
	{
		List<AccountDetails> accList = new ArrayList<AccountDetails>();
		sql="select * from AccountBank";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				AccountDetails ad1 = new AccountDetails();
				ad1.setCustId(rs.getString("CustomerId"));
				ad1.setCustName(rs.getString("CustomerName"));
				ad1.setCustAccNo(rs.getString("CustomerAccNo"));
				ad1.setCustBalance(Double.parseDouble(rs.getString("CustomerBalance")));
				ad1.setBank(rs.getString("Bank"));
				ad1.setBranch(rs.getString("Branch"));
				ad1.setIFSC(rs.getString("IFSC"));
				accList.add(ad1);
			}
			return accList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean debitAccount(String custId, double debitAmt) 
	{
		AccountDetailsDaoImp addi = new AccountDetailsDaoImp(); 
		ad = addi.myAccount(custId);
		double custBalance = ad.getCustBalance() - debitAmt;
		sql="update AccountBank SET CustomerBalance = ? where CustomerId = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, custBalance);
			psmt.setString(2, custId);
			int i = psmt.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return false;
	}

	

}
