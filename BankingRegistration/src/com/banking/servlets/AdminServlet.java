package com.banking.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.dao.AccountDetailsDaoImp;
import com.banking.dao.CustomerDaoImp;
import com.banking.dao.TransferMoneyDaoImp;
import com.banking.pojo.AccountDetails;
import com.banking.pojo.Customer;
import com.banking.pojo.TransferMoney;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CustomerDaoImp cdi = new CustomerDaoImp();
		AccountDetailsDaoImp acdi = new AccountDetailsDaoImp();
		TransferMoneyDaoImp tmdi = new TransferMoneyDaoImp();
		String hiddenAction = request.getParameter("hiddenAction");
		
		if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("allCustomer"))
		{
			List<Customer> custList = cdi.displayAllCustomer();
			request.setAttribute("custList", custList);
			RequestDispatcher rd = request.getRequestDispatcher("displayAllCustomer.jsp");
			rd.forward(request, response);
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("allAccounts"))
		{
			List<AccountDetails> accList = acdi.displayAllAccounts();
			request.setAttribute("accList", accList);
			RequestDispatcher rd = request.getRequestDispatcher("displayAllAccounts.jsp");
			rd.forward(request, response);
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("allTransactions"))
		{
			List<TransferMoney> tranList = tmdi.allTransactions();
			request.setAttribute("tranList", tranList);
			RequestDispatcher rd = request.getRequestDispatcher("allTransactions.jsp");
			rd.forward(request, response);
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("deleteAccount"))
		{
			String custAccNo = request.getParameter("custAccNo");
			boolean b = acdi.deleteAccount(custAccNo);
			if(b==true)
			{
				request.setAttribute("Success", "Account deleted successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("Error", "Error! Account deletion unsuccessful!");
				RequestDispatcher rd = request.getRequestDispatcher("displayAllAccounts.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Customer c = new Customer();
		CustomerDaoImp cdi = new CustomerDaoImp();
		AccountDetails ad = new AccountDetails();
		AccountDetailsDaoImp addi = new AccountDetailsDaoImp();
		List<Customer> custList = new ArrayList<Customer>();
		List<AccountDetails> accList = new ArrayList<AccountDetails>();
		String hiddenAction = request.getParameter("hiddenAction");
		
		if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("searchCustId"))
		{
			String custId = request.getParameter("custId");
			c = cdi.searchCustomerById(custId);
			custList.add(c);
			request.setAttribute("custList", custList);
			RequestDispatcher rd = request.getRequestDispatcher("displayAllCustomer.jsp");
			rd.forward(request, response);
			
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("searchAccNo"))
		{
			String custAccNo = request.getParameter("custAccNo");
			ad = addi.searchAccountByAccNo(custAccNo);
			accList.add(ad);
			request.setAttribute("accList", accList);
			RequestDispatcher rd = request.getRequestDispatcher("displayAllAccounts.jsp");
			rd.forward(request, response);
		}
		
	}

}
