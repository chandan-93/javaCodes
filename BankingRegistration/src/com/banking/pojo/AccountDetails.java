package com.banking.pojo;

public class AccountDetails 
{
	private String custId;
	private String custName;
	private String custAccNo;
	private double custBalance;
	private String bank;
	private String branch;
	private String IFSC;
	
	public AccountDetails()
	{
		
	}

	public AccountDetails(String custId, String custName, String custDOB,
			String custAccNo, double custBalance, String bank, String branch,
			String iFSC) {
		super();
		this.custId = custId;
		this.custName = custName;
		
		this.custAccNo = custAccNo;
		this.custBalance = custBalance;
		this.bank = bank;
		this.branch = branch;
		IFSC = iFSC;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}



	public String getCustAccNo() {
		return custAccNo;
	}

	public void setCustAccNo(String custAccNo) {
		this.custAccNo = custAccNo;
	}

	public double getCustBalance() {
		return custBalance;
	}

	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	@Override
	public String toString() {
		return "AccountDetails [custId=" + custId + ", custName=" + custName
				+ ", custAccNo=" + custAccNo
				+ ", custBalance=" + custBalance + ", bank=" + bank
				+ ", branch=" + branch + ", IFSC=" + IFSC + "]";
	}

	
}
