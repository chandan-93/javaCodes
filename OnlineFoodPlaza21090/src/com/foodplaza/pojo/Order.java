package com.foodplaza.pojo;

public class Order {
	
	private int orderId;
	private String custEmail;
	private double totalPrice;
	private String status;
	
	public Order() 
	{
		super();
	}

	public Order(int orderId, String custEmail, double totalPrice, String status) {
		super();
		this.orderId = orderId;
		this.custEmail = custEmail;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custEmail=" + custEmail
				+ ", totalPrice=" + totalPrice + ", status=" + status + "]";
	}
 
}
