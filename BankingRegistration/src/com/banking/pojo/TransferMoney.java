package com.banking.pojo;

public class TransferMoney 
{
	private String custId;
	private String benName;
	private String benAccNo;
	private String benBank;
	private String benIFSC;
	private double benAmt;
	private String tranDate;
	private String status;
	
	public TransferMoney() 
	{
		
	}

	public TransferMoney(String custId, String benName,
			String benBank, String benAccNo, String benIFSC, double benAmt, String tranDate,
			String status) {
		super();
		this.custId = custId;
		this.benName = benName;
		this.benBank = benBank;
		this.benAccNo = benAccNo;
		this.benIFSC = benIFSC;
		this.benAmt = benAmt;
		this.tranDate = tranDate;
		this.status = status;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TransferMoney [custId=" + custId 
				+ ", benName=" + benName + ", benBank=" + benBank + ", benAccNo="
				+ benAccNo + ", benIFSC=" + benIFSC + ", benAmt=" + benAmt
				+ ", status=" + status + "]";
	}
	
	
	
	
}
