package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.FeedBack;
import com.foodplaza.pojo.Food;
import com.foodplaza.pojo.Order;

public interface FoodPlazaDaoInterface {
	
	// Food methods
	boolean addFood(Food f);
	boolean updateFood(Food f);
	boolean deleteFood(int foodId);
	Food searchFood(int foodId);
	List<Food> displayAllFood();	//List is used since we don't know exact no of database elements
	
	
	//Customer Methods
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int custId);
	Customer searchCustomer(int custId);
	Customer searchByEmail(String email);
	List<Customer> displayAllCustomer();
	
	
	//Cart Methods
	boolean addToCart(Cart ct);
	boolean deleteCart(int cartId);
	boolean deleteCart(String custEmail);
	List<Cart> displayCart(String custEmail);
	
	//Order method
	boolean placeOrder(String custEmail);
	List<Order> displayOrder(String custEmail); 
	
	//AdminLogin method
	boolean adminLogin(String adminName, String adminPassword);
	boolean changeAdminPassword(String adminName, String newAdminPassword);
	
	//CustomerLogin method
	boolean customerLogin(String userName, String pass);
	boolean changeCustomerPassword(String userName, String newPass);
	
	//Customer FeedBack method
	boolean sendFeedback(FeedBack fb);
	
	//Admin FeedBack List
	List<FeedBack> feedBackList(); 
}
