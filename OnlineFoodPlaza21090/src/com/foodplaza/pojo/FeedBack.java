package com.foodplaza.pojo;

public class FeedBack {
	private String name;
	private String custEmail;
	private String phno;
	private String msg;
	
	public FeedBack() {
		super();
	}

	public FeedBack(String name, String custEmail, String phno, String msg) {
		super();
		this.name = name;
		this.custEmail = custEmail;
		this.phno = phno;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "FeedBack [name=" + name + ", custEmail=" + custEmail
				+ ", phno=" + phno + ", msg=" + msg + "]";
	}
	
	
}
