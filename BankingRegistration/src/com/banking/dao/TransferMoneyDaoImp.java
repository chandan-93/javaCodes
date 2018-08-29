package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.pojo.TransferMoney;
import com.banking.utility.ConnectDB;

public class TransferMoneyDaoImp implements TransferMoneyDao
{
	Connection conn = ConnectDB.getConn();
	TransferMoney tm = new TransferMoney();
	String sql = null;

	@Override
	public boolean sendMoney(TransferMoney tm) 
	{
		AccountDetailsDaoImp addi = new AccountDetailsDaoImp();
		sql = "insert into TransactionBank value(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, tm.getCustId());
			psmt.setString(2, tm.getBenName());
			psmt.setString(3, tm.getBenAccNo());
			psmt.setString(4, tm.getBenBank());
			psmt.setString(5, tm.getBenIFSC());
			psmt.setDouble(6, tm.getBenAmt());
			psmt.setString(7, tm.getTranDate());
			psmt.setString(8, tm.getStatus());
			int i = psmt.executeUpdate();
			boolean b = addi.debitAccount(tm.getCustId(), tm.getBenAmt());
			if(i>0 && b==true)
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
	public List<TransferMoney> myTransactions(String custId) 
	{
		List<TransferMoney> myTranList = new ArrayList<TransferMoney>();
		sql="select * from TransactionBank where customerId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				TransferMoney tm = new TransferMoney();
				tm.setCustId(rs.getString("CustomerId"));
				tm.setBenName(rs.getString("BeneficiaryName"));
				tm.setBenAccNo(rs.getString("BeneficiaryAccNo"));
				tm.setBenBank(rs.getString("BeneficiaryBank"));
				tm.setBenIFSC(rs.getString("BeneficiaryIFSC"));
				tm.setBenAmt(rs.getDouble("BeneficiaryAmount"));
				tm.setTranDate(rs.getString("TransactionDate"));
				tm.setStatus(rs.getString("TransactionStatus"));
				myTranList.add(tm);
			}
			return myTranList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TransferMoney> searchTransaction(String custId) 
	{
		List<TransferMoney> tranList = new ArrayList<TransferMoney>();
		sql="select * from TransactionBank where CustomerId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TransferMoney> allTransactions() 
	{
		List<TransferMoney> tranList = new ArrayList<TransferMoney>();
		sql="select * from TransactionBank";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				TransferMoney tm1 = new TransferMoney();
				tm1.setCustId(rs.getString("CustomerId"));
				tm1.setBenName(rs.getString("BeneficiaryName"));
				tm1.setBenAccNo(rs.getString("BEneficiaryAccNo"));
				tm1.setBenBank(rs.getString("BeneficiaryBank"));
				tm1.setBenIFSC(rs.getString("BeneficiaryIFSC"));
				tm1.setBenAmt(Double.parseDouble(rs.getString("BeneficiaryAmount")));
				tm1.setTranDate(rs.getString("TransactionDate"));
				tm1.setStatus(rs.getString("TransactionStatus"));
				tranList.add(tm1);
			}
			return tranList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean approveTransaction(String custId) 
	{
		sql = "update TransactionBank SET TransactionStatus = ? WHERE CustomerId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "Success");
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
		
		return false;
	}

	@Override
	public boolean deleteTransaction(String custId) 
	{
		sql = "delete from TransactionBank where CustomerId=?";
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

}
