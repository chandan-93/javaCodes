package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.FeedBack;
import com.foodplaza.pojo.Food;
import com.foodplaza.pojo.Order;
import com.foodplaza.utility.DBConnectivity;

public class FoodPlazaDao implements FoodPlazaDaoInterface {
	
	Connection conn = DBConnectivity.getDBConnection();
	String sql = null;

	@Override
	public boolean addFood(Food f) 
	{
		try
		{
			sql = "insert into Food21090(FoodName, FoodPrice, FoodType) values(?,?,?)";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, f.getFoodName());
			psmt.setDouble(2, f.getFoodPrice());
			psmt.setString(3, f.getFoodType());
			
			int i = psmt.executeUpdate();
			
			if(i>0)
				return true;
			else
				return false;
			
		}catch(Exception e)
			{
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateFood(Food f) {
		
		try
		{
			sql = "update Food21090 set FoodName=?, FoodPrice=?, FoodType=? where FoodId=?";
		
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, f.getFoodName());
			psmt.setDouble(2, f.getFoodPrice());
			psmt.setString(3, f.getFoodType());
			psmt.setInt(4, f.getFoodId());
			int i = psmt.executeUpdate();
			
			if(i>0)
				return true;
			else
				return false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteFood(int foodId) {
		
		try {
			sql = "delete from Food21090 where FoodId = ?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, foodId);
			
			int i = psmt.executeUpdate();
			
			if(i>0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Food searchFood(int foodId) {
		
		Food f = new Food();
		try {
			sql = "select * from Food21090 where FoodId = ?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, foodId);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				
				f.setFoodId(rs.getInt("FoodId"));
				f.setFoodName(rs.getString("FoodName"));
				f.setFoodPrice(rs.getDouble("FoodPrice"));
				f.setFoodType(rs.getString("FoodType"));
			}
			return f;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Food> displayAllFood() {
		
		List<Food> l = new ArrayList<Food>();
		
		sql = "select * from Food21090";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				Food f = new Food();
				f.setFoodId(rs.getInt("FoodId"));
				f.setFoodName(rs.getString("FoodName"));
				f.setFoodPrice(rs.getDouble("FoodPrice"));
				f.setFoodType(rs.getString("FoodType"));
				l.add(f);
			}
			
			return l;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public boolean addCustomer(Customer c) {
		
		try {
			sql = "insert into Customer21090(CustomerName, CustomerPhno, CustomerAddress, CustomerEmail, CustomerPassword) values(?,?,?,?,?)";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, c.getCustName());
			psmt.setString(2, c.getCustPhno());
			psmt.setString(3, c.getCustAddress());
			psmt.setString(4, c.getCustEmail());
			psmt.setString(5, c.getCustPassword());
			int i = psmt.executeUpdate();
			
			if(i>0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		
		try {
			sql = "update Customer21090 set CustomerName=?, CustomerPhno=?, CustomerAddress=?, CustomerEmail=?, CustomerPassword=? where CustomerId=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, c.getCustName());
			psmt.setString(2, c.getCustPhno());
			psmt.setString(3, c.getCustAddress());
			psmt.setString(4, c.getCustEmail());
			psmt.setString(5, c.getCustPassword());
			psmt.setInt(6, c.getCustId());
			int i = psmt.executeUpdate();
			
			if(i>0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteCustomer(int custId) {
		
		try {
			sql = "delete from Customer21090 where CustomerId = ?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, custId);
			int i = psmt.executeUpdate();
			
			if(i>0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Customer searchCustomer(int custId) {
		Customer c = new Customer();
		try {
			sql = "select * from Customer21090 where CustomerId = ?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, custId);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				c.setCustId(rs.getInt("CustomerId"));
				c.setCustName(rs.getString("CustomerName"));
				c.setCustPhno(rs.getString("CustomerPhno"));
				c.setCustAddress(rs.getString("CustomerAddress"));
				c.setCustEmail(rs.getString("CustomerEmail"));
				c.setCustPassword(rs.getString("CustomerPassword"));
			}
			return c;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Customer searchByEmail(String custEmail) 
	{	
		Customer c = new Customer();
		try {
			sql = "select * from Customer21090 where CustomerEmail=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custEmail);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				c.setCustId(rs.getInt("CustomerId"));
				c.setCustName(rs.getString("CustomerName"));
				c.setCustPhno(rs.getString("CustomerPhno"));
				c.setCustAddress(rs.getString("CustomerAddress"));
				c.setCustEmail(rs.getString("CustomerEmail"));
				c.setCustPassword(rs.getString("CustomerPassword"));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Customer> displayAllCustomer() {
		
		List<Customer> l = new ArrayList<Customer>();
		try {
			sql = "select * from Customer21090";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustId(rs.getInt("CustomerId"));
				c.setCustName(rs.getString("CustomerName"));
				c.setCustPhno(rs.getString("CustomerPhno"));
				c.setCustAddress(rs.getString("CustomerAddress"));
				c.setCustEmail(rs.getString("CustomerEmail"));
				c.setCustPassword(rs.getString("CustomerPassword"));
				l.add(c);
			}
			
			return l;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addToCart(Cart ct) {
		String foodName = null;
		double foodPrice = 0.0;
		
		try {
			sql = "select FoodName, FoodName, FoodPrice from Food21090 where FoodId=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ct.getFoodId());
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				ct.setFoodName(rs.getString("FoodName"));
				ct.setFoodPrice(rs.getDouble("FoodPrice"));
			}
			
			sql = "insert into Cart21090(FoodId, FoodName, FoodPrice, Qty, CustomerEmail) values(?,?,?,?,?)";
			PreparedStatement psmt1 = conn.prepareStatement(sql);
			psmt1.setInt(1, ct.getFoodId());
			psmt1.setString(2, ct.getFoodName());
			psmt1.setDouble(3, ct.getFoodPrice());
			psmt1.setInt(4, ct.getQty());
			psmt1.setString(5, ct.getCustEmail());
			
			int i = psmt1.executeUpdate();
			if(i>0)
				return true;
			else
				return false;	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteCart(int cartId) {
	
		try {
			sql = "delete from Cart21090 where CartId = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cartId);
			
			int i = psmt.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean deleteCart(String custEmail) {
		
		try {
			sql = "delete from Cart21090 where CustomerEmail = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custEmail);
			
			int i = psmt.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> displayCart(String custEmail) {
		
		List<Cart> l = new ArrayList<Cart>();
		
		try {
			sql = "select * from Cart21090 where CustomerEmail = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custEmail);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				Cart ct = new Cart();
				ct.setCartId(rs.getInt("CartId"));
				ct.setFoodId(rs.getInt("FoodId"));
				ct.setFoodName(rs.getString("FoodName"));
				ct.setFoodPrice(rs.getDouble("FoodPrice"));
				ct.setQty(rs.getInt("Qty"));
				ct.setCustEmail(rs.getString("CustomerEmail"));
				l.add(ct);
			}
			return l;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean placeOrder(String custEmail) {
		double totalPrice = 0.0;
		
		try {
			sql = "select sum(FoodPrice * Qty) as TotalPrice from Cart21090 where CustomerEmail=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custEmail);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				totalPrice = rs.getDouble("TotalPrice");
			}
			
			sql = "insert into Order21090(CustomerEmail, TotalPrice, Status) values(?,?,?)";
			PreparedStatement psmt1 = conn.prepareStatement(sql);
			psmt1.setString(1, custEmail);
			psmt1.setDouble(2, totalPrice);
			psmt1.setString(3, "Processing"); 
			
			int i = psmt1.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Order> displayOrder(String custEmail) {
		
		List<Order> l = new ArrayList<Order>();
		
		try {
			sql = "select * from Order21090 where CustomerEmail = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, custEmail);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				Order o = new Order();
				o.setOrderId(rs.getInt("OrderId"));
				o.setCustEmail(rs.getString("CustomerEmail"));
				o.setTotalPrice(rs.getDouble("TotalPrice"));
				o.setStatus(rs.getString("Status"));
				l.add(o);
			}
			return l;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean adminLogin(String userEmail, String adminPassword) {
		
		try {
			sql = "select * from Admin21090 where AdminName= ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, userEmail);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				if(userEmail.equals(rs.getString("AdminName")) && adminPassword.equals(rs.getString("AdminPassword")))
					return true;
				else
					return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean customerLogin(String userEmail, String pass) {
		
		try {
			sql = "select CustomerEmail, CustomerPassword from Customer21090 where CustomerEmail=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, userEmail);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				if(userEmail.equals(rs.getString("CustomerEmail")) && pass.equals(rs.getString("CustomerPassword")))
					return true;
				else
					return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean changeAdminPassword(String adminName, String newAdminPassword) {
		
		try {
			sql="update Admin21090 set AdminPassword=? where AdminName=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, newAdminPassword);
			psmt.setString(2, adminName);
			
			int i = psmt.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean changeCustomerPassword(String userName, String newPass) {
		
		try {
			sql="update Customer21090 set CustomerPassword=? where CustomerName=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, newPass);
			psmt.setString(2, userName);
			
			int i = psmt.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean sendFeedback(FeedBack fb) {
		
		sql="insert into FeedBack21090 values(?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, fb.getName());
			psmt.setString(2, fb.getCustEmail());
			psmt.setString(3, fb.getPhno());
			psmt.setString(4, fb.getMsg());
			
			int i = psmt.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<FeedBack> feedBackList() {
		
		List<FeedBack> l = new ArrayList<FeedBack>();
		
		sql = "select * from FeedBack21090";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				FeedBack fb = new FeedBack();
				fb.setName(rs.getString("CustomerName"));
				fb.setCustEmail(rs.getString("CustomerEmail"));
				fb.setPhno(rs.getString("CustomerPhno"));
				fb.setMsg(rs.getString("CustomerMessage"));
				l.add(fb);
			}

			return l;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
	
}
