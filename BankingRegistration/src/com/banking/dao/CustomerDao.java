package com.banking.dao;

import java.util.List;

import com.banking.pojo.Customer;

public interface CustomerDao
{
	//Customer methods
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean customerLogin(String custId, String custPassword);
	
	//Admin methods
	boolean deleteCustomer(String custId);
	Customer searchCustomerById(String custId);
	List<Customer> displayAllCustomer();
	
	
}
