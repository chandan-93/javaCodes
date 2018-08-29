package com.banking.dao;

import java.util.List;

import com.banking.pojo.TransferMoney;

public interface TransferMoneyDao
{
	//Customer methods
	boolean sendMoney(TransferMoney tm);
	List<TransferMoney> myTransactions(String custId);
	
	//Admin methods
	List<TransferMoney> searchTransaction(String custId);
	List<TransferMoney> allTransactions();
	boolean approveTransaction(String custId);
	boolean deleteTransaction(String custId);
}
