package com.banking.pojo;

public class BeneficiaryAccount 
{
	private int custId;
	private int benId;
	private String benName;
	private String benBank;
	private String benAccNo;
	private String benIFSC;
	private double benAmt;
	
	public BeneficiaryAccount()
	{
		
	}

	public BeneficiaryAccount(int custId, int benId, String benName,
			String benBank, String benAccNo, String benIFSC, double benAmt) {
		super();
		this.custId = custId;
		this.benId = benId;
		this.benName = benName;
		this.benBank = benBank;
		this.benAccNo = benAccNo;
		this.benIFSC = benIFSC;
		this.benAmt = benAmt;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getBenId() {
		return benId;
	}

	public void setBenId(int benId) {
		this.benId = benId;
	}

	public String getBenName() {
		return benName;
	}

	public void setBenName(String benName) {
		this.benName = benName;
	}

	public String getBenBank() {
		return benBank;
	}

	public void setBenBank(String benBank) {
		this.benBank = benBank;
	}

	public String getBenAccNo() {
		return benAccNo;
	}

	public void setBenAccNo(String benAccNo) {
		this.benAccNo = benAccNo;
	}

	public String getBenIFSC() {
		return benIFSC;
	}

	public void setBenIFSC(String benIFSC) {
		this.benIFSC = benIFSC;
	}

	public double getBenAmt() {
		return benAmt;
	}

	public void setBenAmt(double benAmt) {
		this.benAmt = benAmt;
	}

	@Override
	public String toString() {
		return "BeneficiaryAccount [custId=" + custId + ", benId=" + benId
				+ ", benName=" + benName + ", benBank=" + benBank
				+ ", benAccNo=" + benAccNo + ", benIFSC=" + benIFSC
				+ ", benAmt=" + benAmt + "]";
	}
	
	
}
