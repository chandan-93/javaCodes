package com.foodplaza.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.FoodPlazaDao;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Food;

/**
 * Servlet implementation class CommonFoodServlet
 */
@WebServlet("/CommonFoodServlet")
public class CommonFoodServlet extends HttpServlet {
	

	
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Food f= new Food();
		FoodPlazaDao fpd = new FoodPlazaDao();
		Cart ct = new Cart();
		
		String operation = request.getParameter("hiddenAction");
		
		if(operation!=null && operation.equalsIgnoreCase("edit"))
		{
		
			int foodId = Integer.parseInt(request.getParameter("ID"));
			f = fpd.searchFood(foodId);
			request.setAttribute("foodList", f);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateFood.jsp");
			rd.forward(request, response);
		}
		else if(operation!=null && operation.equalsIgnoreCase("addToCart"))
		{
			HttpSession session = request.getSession();
			int foodId = Integer.parseInt(request.getParameter("ID"));
			f = fpd.searchFood(foodId);
			ct.setFoodId(foodId);
			ct.setFoodName(f.getFoodName());
			ct.setFoodPrice(f.getFoodPrice());
			ct.setQty(1);
			ct.setCustEmail((String)session.getAttribute("customerLog"));
			boolean b = fpd.addToCart(ct);
			
			if(b==true)
			{	//response.sendRedirect("Success.jsp");
				List<Food> l = fpd.displayAllFood();
				request.setAttribute("foodList", l);
				request.setAttribute("Success", "Added to cart successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowAllFood.jsp");
				rd.forward(request , response);
			}
			else
				response.sendRedirect("Failure.jsp");
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("delete"))
		{
			int foodId = Integer.parseInt(request.getParameter("ID"));
			boolean b = fpd.deleteFood(foodId);
			if(b==true)
			{
				request.setAttribute("Success", "Food deleted successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect("Failure.jsp");
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("showCart"))
		{
			HttpSession session = request.getSession();
			String custEmail = (String)session.getAttribute("customerLog");
			List<Cart> l = fpd.displayCart(custEmail);
			request.setAttribute("cart", l);
			RequestDispatcher rd = request.getRequestDispatcher("showCart.jsp");
			rd.forward(request, response);
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("deleteCart"))
		{
			int cartId = Integer.parseInt(request.getParameter("ID"));
			boolean b = fpd.deleteCart(cartId);
			if(b==true)
			{
					response.sendRedirect("CommonFoodServlet?hiddenAction=showCart");
			}
		}
		
		else
		{
			List<Food> l = fpd.displayAllFood();
			request.setAttribute("foodList", l);
			RequestDispatcher rd = request.getRequestDispatcher("ShowAllFood.jsp");
			rd.forward(request , response);
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Food f= new Food();
		FoodPlazaDao fpd = new FoodPlazaDao();
		
		String operation = request.getParameter("hiddenAction");
	
		if(operation!=null && operation.equalsIgnoreCase("addFood"))
		{
			
			f.setFoodName(request.getParameter("foodName"));
			f.setFoodPrice(Double.parseDouble(request.getParameter("foodPrice")));
			f.setFoodType(request.getParameter("foodType"));
			
			boolean b = fpd.addFood(f);
			if(b==true)
			{
				request.setAttribute("Success", "Food added successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect("Failure.jsp");
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("updateFood"))
		{
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			f.setFoodId(foodId);
			String foodName = request.getParameter("foodName");
			f.setFoodName(foodName);
			Double foodPrice = Double.parseDouble(request.getParameter("foodPrice"));
			f.setFoodPrice(foodPrice);
			String foodType = request.getParameter("foodType");
			f.setFoodType(foodType);
			
			boolean b = fpd.updateFood(f);
			if(b==true)
				response.sendRedirect("CommonFoodServlet");
			else
				response.sendRedirect("Failure.jsp");
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("placeOrder"))
		{
			HttpSession session = request.getSession();
			String custEmail = (String)session.getAttribute("customerLog");
			
			boolean b = fpd.placeOrder(custEmail);
			if(b==true)
			{
				b = fpd.deleteCart(custEmail);
				request.setAttribute("Success", "Congrats, Order placed successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect("Failure.jsp");
			
		}
		
	}
}
