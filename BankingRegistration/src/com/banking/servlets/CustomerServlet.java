package com.banking.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.dao.AccountDetailsDaoImp;
import com.banking.dao.AdminDaoImp;
import com.banking.dao.CustomerDaoImp;
import com.banking.pojo.AccountDetails;
import com.banking.pojo.Admin;
import com.banking.pojo.Customer;
import com.banking.pojo.TransferMoney;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Customer c = new Customer();
		CustomerDaoImp cdi = new CustomerDaoImp();
		AccountDetails ad = new AccountDetails();
		AccountDetailsDaoImp acdi = new AccountDetailsDaoImp();
		String hiddenAction = request.getParameter("hiddenAction");
		
		if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("custEdit"))
		{
			HttpSession session = request.getSession();
			String custId = (String)session.getAttribute("customerLog");
			c = cdi.searchCustomerById(custId);
			request.setAttribute("custProfile", c);
			RequestDispatcher rd = request.getRequestDispatcher("updateCustomer.jsp");
			rd.forward(request, response);
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("adminCustEdit"))
		{
			String custId = request.getParameter("custId");
			c = cdi.searchCustomerById(custId);
			request.setAttribute("custProfile", c);
			RequestDispatcher rd = request.getRequestDispatcher("updateCustomer.jsp");
			rd.forward(request, response);
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("custDelete"))
		{
			String custId = request.getParameter("custId");
			ad = acdi.myAccount(custId);
			boolean b = cdi.deleteCustomer(custId);
			
			if(b==true)
			{
					
					request.setAttribute("Success", "Customer removed successfully!");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
			}
			else
			{
					request.setAttribute("Error", "Customer removal unsuccessfully!");
					RequestDispatcher rd = request.getRequestDispatcher("displayAllCustomer.jsp");
					rd.forward(request, response);
			}
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("custAccount"))
		{
			HttpSession session = request.getSession();
			String custId = (String)session.getAttribute("customerLog");
			ad = acdi.myAccount(custId);
			request.setAttribute("myAccount", ad);
			RequestDispatcher rd = request.getRequestDispatcher("myAccount.jsp");
			rd.forward(request, response);
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("logout"))
		{
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("Success", "You are logged out successfully!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Customer c = new Customer();
		CustomerDaoImp cdi = new CustomerDaoImp();
		Admin a = new Admin();
		AdminDaoImp adi = new AdminDaoImp();
		AccountDetails ad = new AccountDetails();
		AccountDetailsDaoImp acdi = new AccountDetailsDaoImp();
		
		String hiddenAction = request.getParameter("hiddenAction");
		
		if(hiddenAction!= null && hiddenAction.equalsIgnoreCase("addCustomer"))
		{
			c.setCustName(request.getParameter("custName"));
			c.setCustDOB(request.getParameter("custDOB"));
			c.setCustPhNo(request.getParameter("custPhNo"));
			c.setCustEmail(request.getParameter("custEmail"));
			c.setCustAadhar(request.getParameter("custAadhar"));
			c.setCustPAN(request.getParameter("custPAN"));
			c.setCustAddress(request.getParameter("custAddress"));
			c.setCustId(request.getParameter("custId"));
			c.setCustAccNo(request.getParameter("custAccNo"));
			c.setCustPassword(request.getParameter("custPassword"));
			c.setCustTranPassword(request.getParameter("custTranPassword"));
			
			ad.setCustId(c.getCustId());
			ad.setCustName(c.getCustName());
			ad.setCustAccNo(c.getCustAccNo());
			ad.setCustBalance(10000);
			ad.setBank("Abc Bank");
			ad.setBranch(request.getParameter("branch"));
			ad.setIFSC("ABC1200");
			
			boolean b = cdi.addCustomer(c);
			if(b == true)
			{
				b = acdi.addAccount(ad);
				if(b == true)
				{
					request.setAttribute("Success", "Account created successfully. Please Login!");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Error", "Error! Account registration unsuccessful");
					RequestDispatcher rd = request.getRequestDispatcher("addCustomer.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				request.setAttribute("Error", "Error! Customer registration unsuccessful");
				RequestDispatcher rd = request.getRequestDispatcher("addCustomer.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("custUpdate"))
		{
			c.setCustPhNo(request.getParameter("custPhNo"));
			c.setCustEmail(request.getParameter("custEmail"));
			c.setCustAddress(request.getParameter("custAddress"));
			c.setCustId(request.getParameter("custId"));
			c.setCustPassword(request.getParameter("custPassword"));
			c.setCustTranPassword(request.getParameter("custTranPassword"));
			
			boolean b = cdi.updateCustomer(c);
			if(b == true)
			{
				request.setAttribute("Success", "Sucess! Your details have been updated.");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Error", "Error! updation unsuccessful! please try later!");
				RequestDispatcher rd = request.getRequestDispatcher("updateCustomer.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("login"))
		{
			HttpSession session = request.getSession();
			String user = request.getParameter("user");
			String userId = request.getParameter("userId");
			String userPassword = request.getParameter("userPassword");
			
			if(user.equalsIgnoreCase("customer"))
			{	
				boolean b = cdi.customerLogin(userId, userPassword);
				if(b == true)
				{
					session.setAttribute("customerLog", userId);
					request.setAttribute("Success", "You are successfully logged in");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Error", "Invalid customer Id or password");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			}
			else if(user.equalsIgnoreCase("admin"))
			{
				boolean b = adi.adminLogin(userId, userPassword);
				System.out.println(b);
				if(b == true)
				{
					session.setAttribute("adminLog", userId);
					request.setAttribute("Success", "You are successfully logged in");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Error", "Invalid username os password");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
				
			}
			
		}
		
		
	}

}
