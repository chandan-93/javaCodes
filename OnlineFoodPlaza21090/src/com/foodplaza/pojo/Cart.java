package com.foodplaza.pojo;

public class Cart {
	private int cartId;
	private int foodId;
	private String foodName;
	private double foodPrice;
	private int qty;
	private String custEmail;
	
	public Cart() 
	{
		
	}

	public Cart(int cartId, int foodId, String foodName, double foodPrice, int qty, String custEmail) 
	{
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.qty = qty;
		this.custEmail = custEmail;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", foodName="
				+ foodName + ", foodPrice=" + foodPrice + ", qty=" + qty
				+ ", custEmail=" + custEmail + "]";
	}

	
}
