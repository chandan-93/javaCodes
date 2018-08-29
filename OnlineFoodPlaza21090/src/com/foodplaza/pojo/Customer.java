package com.foodplaza.pojo;

public class Customer {
	
	private int custId;
	private String custName;
	private String CustPhno;
	private String custAddress;
	private String custEmail;
	private String custPassword;
	
	public Customer()
	{
		
	}
	
	public Customer(int custId, String custName, String custPhno, String custAddress, String custEmail, String custPassword) 
	{
		super();
		this.custId = custId;
		this.custName = custName;
		this.CustPhno = custPhno;
		this.custAddress = custAddress;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPhno() {
		return CustPhno;
	}

	public void setCustPhno(String custPhno) {
		CustPhno = custPhno;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", CustPhno=" + CustPhno + ", custAddress=" + custAddress
				+ ", custEmail=" + custEmail + ", custPassword=" + custPassword + "]";
	}
	
	
}
