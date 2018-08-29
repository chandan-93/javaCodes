package com.banking.pojo;

public class Customer 
{
	private String custName;
	private String custDOB;
	private String custPhNo;
	private String custEmail;
	private String custAadhar;
	private String custPAN;
	private String custAddress;
	private String custAccNo;
	private String custId;
	private String custPassword;
	private String custTranPassword;
	 
	public Customer()
	{
		
	}

	public Customer(String custName, String custDOB, String custPhNo, String custEmail, String custAadhar, 
			String custPAN, String custAddress, String custAccNo, String custId, String custPassword,
			String custTranPassword) 
	{
		super();
		this.custName = custName;
		this.custDOB = custDOB;
		this.custPhNo = custPhNo;
		this.custEmail = custEmail;
		this.custAadhar = custAadhar;
		this.custPAN = custPAN;
		this.custAddress = custAddress;
		this.custAccNo = custAccNo;
		this.custId = custId;
		this.custPassword = custPassword;
		this.custTranPassword = custTranPassword;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(String custDOB) {
		this.custDOB = custDOB;
	}

	public String getCustPhNo() {
		return custPhNo;
	}

	public void setCustPhNo(String custPhNo) {
		this.custPhNo = custPhNo;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAadhar() {
		return custAadhar;
	}

	public void setCustAadhar(String custAadhar) {
		this.custAadhar = custAadhar;
	}

	public String getCustPAN() {
		return custPAN;
	}

	public void setCustPAN(String custPAN) {
		this.custPAN = custPAN;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustAccNo() {
		return custAccNo;
	}

	public void setCustAccNo(String custAccNo) {
		this.custAccNo = custAccNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustTranPassword() {
		return custTranPassword;
	}

	public void setCustTranPassword(String custTranPassword) {
		this.custTranPassword = custTranPassword;
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", custDOB=" + custDOB
				+ ", custPhNo=" + custPhNo + ", custEmail=" + custEmail
				+ ", custAadhar=" + custAadhar + ", custPAN=" + custPAN
				+ ", custAddress=" + custAddress + ", custAccNo=" + custAccNo
				+ ", custId=" + custId + ", custPassword=" + custPassword
				+ ", custTranPassword=" + custTranPassword + "]";
	}
	
	
	
}
