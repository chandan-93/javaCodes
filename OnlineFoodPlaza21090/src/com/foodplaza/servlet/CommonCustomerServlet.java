package com.foodplaza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.FoodPlazaDao;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.FeedBack;

/**
 * Servlet implementation class CommonCustomerServlet
 */

@WebServlet("/CommonCustomerServlet")
public class CommonCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		FoodPlazaDao fpd = new FoodPlazaDao();
		FeedBack fb = new FeedBack();
		
		String operation = request.getParameter("hiddenAction");
		if(operation!=null && operation.equalsIgnoreCase("edit"))
		{
			int custId = Integer.parseInt(request.getParameter("ID"));
			c = fpd.searchCustomer(custId);
			request.setAttribute("customerList", c);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
			rd.forward(request, response);
		}
		else if(operation!=null && operation.equalsIgnoreCase("editProfile"))
		{
			HttpSession session = request.getSession();
			String custEmail = (String)session.getAttribute("customerLog");
			c = fpd.searchByEmail(custEmail);
			request.setAttribute("customerList", c);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
			rd.forward(request, response);
		}
		else if(operation!=null && operation.equalsIgnoreCase("delete"))
		{
			int custId = Integer.parseInt(request.getParameter("ID"));
			boolean b = fpd.deleteCustomer(custId);
			if(b==true)
			{
				request.setAttribute("Success", "Customer deleted successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect("Failure.jsp");
		}
		else if(operation!=null && operation.equalsIgnoreCase("contactUs"))
		{
			HttpSession session = request.getSession();
			String custEmail = (String)session.getAttribute("customerLog");
			c = fpd.searchByEmail(custEmail);
			request.setAttribute("feedBackForm", c);
			RequestDispatcher rd = request.getRequestDispatcher("feedBack.jsp");
			rd.forward(request, response);
		}
		else if(operation!=null && operation.equalsIgnoreCase("feedBackList"))
		{
			List<FeedBack> l = fpd.feedBackList();
			request.setAttribute("allFeedBack", l);
			RequestDispatcher rd = request.getRequestDispatcher("showAllFeedBack.jsp");
			rd.forward(request, response);
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("logout"))
		{
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("Success", "Logged out successfully!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			List<Customer> l = fpd.displayAllCustomer();
			request.setAttribute("customerList", l);
			RequestDispatcher rd = request.getRequestDispatcher("ShowAllCustomer.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer c = new Customer();
		FoodPlazaDao fpd = new FoodPlazaDao();
		FeedBack fb = new FeedBack();
		
		String operation = request.getParameter("hiddenAction");
		
		if(operation!=null && operation.equalsIgnoreCase("addCustomer"))
		{
			PrintWriter out = response.getWriter();
			out.print("success");
			c.setCustName(request.getParameter("custName"));
			c.setCustPhno(request.getParameter("custPhno"));
			c.setCustAddress(request.getParameter("custAddress"));
			c.setCustEmail(request.getParameter("custEmail"));
			c.setCustPassword(request.getParameter("custPass"));
			
			boolean b = fpd.addCustomer(c);
			if(b==true)
			{
				request.setAttribute("Success", "Registered Successfully, Please Login");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Error", "Error! Registration Unsuccessful! Please try again");
				RequestDispatcher rd = request.getRequestDispatcher("AddCustomer.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("updateCustomer"))
		{
			int custId = Integer.parseInt(request.getParameter("custId"));
			c.setCustId(custId);
			String custName = request.getParameter("custName");
			c.setCustName(custName);
			String custPhno = request.getParameter("custPhno");
			c.setCustPhno(custPhno);
			String custAddress = request.getParameter("custAddress");
			c.setCustAddress(custAddress);
			String custEmail = request.getParameter("custEmail");
			c.setCustEmail(custEmail);
			String custPassword = request.getParameter("custPass");
			c.setCustPassword(custPassword);
			
			boolean b = fpd.updateCustomer(c);
			if(b==true)
			{
				request.setAttribute("Success", "Profile updated successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Error", "Error! Please try again!");
				RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation!=null && operation.equalsIgnoreCase("sendFeedback"))
		{
			String name = request.getParameter("custName");
			fb.setName(name);
			String custEmail = request.getParameter("custEmail");
			fb.setCustEmail(custEmail);
			String phno = request.getParameter("phno");
			fb.setPhno(phno);
			String msg = request.getParameter("msg");
			fb.setMsg(msg);
			boolean b = fpd.sendFeedback(fb);
			if(b==true)
			{
				request.setAttribute("Success", "Message send successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect("Failure.jsp");
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("loginPage"))
		{
			HttpSession session = request.getSession();
			
			String user = request.getParameter("user");
			String userEmail = request.getParameter("userEmail");
			String pass = request.getParameter("pass");
			if(user.equalsIgnoreCase("Admin"))
			{
				boolean b = fpd.adminLogin(userEmail, pass);
				if(b==true)
				{	
					session.setAttribute("adminLog", userEmail);
					request.setAttribute("Success", "Welcome to Food Plaza, "+ userEmail);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{	
					request.setAttribute("Error", "Invalid username or password");
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}
			else if(user.equalsIgnoreCase("Customer"))
			{
				boolean b = fpd.customerLogin(userEmail, pass);
				if(b==true)
				{
					session.setAttribute("customerLog", userEmail);
					//c = (Customer)session.getAttribute("customerLog");
					
					request.setAttribute("Success", "Welcome to Food Plaza, "+ userEmail);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Error", "Invalid username or password");
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("changePassword"))
		{	
			//String user = request.getParameter("user");
			String userEmail = request.getParameter("loginEmail");
			String oldPass = request.getParameter("oldPassword");
			String newPass = request.getParameter("newPassword");
	
			boolean b = fpd.adminLogin(userEmail, oldPass);
				if(b==true)
				{
					b = fpd.changeAdminPassword(userEmail, newPass);
					if(b==true)
					{
						request.setAttribute("Success", "Password changed successfully!");
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
					}
					else
						response.sendRedirect("Failure.jsp");
						
				}
			
			
			
			
		}
		
	}

}
