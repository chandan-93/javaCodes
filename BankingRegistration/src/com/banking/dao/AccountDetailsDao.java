package com.banking.dao;

import java.util.List;

import com.banking.pojo.AccountDetails;

public interface AccountDetailsDao
{
	//Customer methods
	boolean addAccount(AccountDetails ad);
	AccountDetails myAccount(String custId);
	boolean debitAccount(String custId, double debitAmt);
	
	//Admin methods
	AccountDetails searchAccountByAccNo(String custAccNo);
	boolean deleteAccount(String custAccNo);
	List<AccountDetails> displayAllAccounts();
}
