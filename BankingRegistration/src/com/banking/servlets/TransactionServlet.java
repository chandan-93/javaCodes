package com.banking.servlets;

import java.io.IOException;
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

import com.banking.dao.TransferMoneyDaoImp;
import com.banking.pojo.TransferMoney;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		TransferMoneyDaoImp tmdi = new TransferMoneyDaoImp();
		String hiddenAction = request.getParameter("hiddenAction");
		if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("myTransactions"))
		{
			HttpSession session = request.getSession();
			String custId = (String)session.getAttribute("customerLog");
			List<TransferMoney> myTranList = tmdi.myTransactions(custId);
			request.setAttribute("myTranList", myTranList);
			RequestDispatcher rd = request.getRequestDispatcher("myTransactions.jsp");
			rd.forward(request, response);
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("deleteTran"))
		{
			String custId = request.getParameter("custId");
			boolean b = tmdi.deleteTransaction(custId);
			if(b==true)
			{
				request.setAttribute("Success", "Transaction deleted successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Error", "Error! Transaction deletion unsuccessful!");
				RequestDispatcher rd = request.getRequestDispatcher("allTransactions.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("approveTran"))
		{
			String custId = request.getParameter("custId");
			boolean b = tmdi.approveTransaction(custId);
			if(b==true)
			{
				request.setAttribute("Success", "Transaction Approved successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Error", "Error! Transaction approval failed!");
				RequestDispatcher rd = request.getRequestDispatcher("allTransactions.jsp");
				rd.forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		TransferMoney tm = new TransferMoney();
		TransferMoneyDaoImp tmdi = new TransferMoneyDaoImp();
		String hiddenAction = request.getParameter("hiddenAction");
		
		if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("transferMoney"))
		{
			Date d1 = new Date();
			DateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
			HttpSession session = request.getSession();
			String custId = (String)session.getAttribute("customerLog");
			System.out.println(custId);
			tm.setCustId(custId);
			tm.setBenName(request.getParameter("benName"));
			tm.setBenAccNo(request.getParameter("benAccNo"));
			tm.setBenBank(request.getParameter("benBank"));
			tm.setBenIFSC(request.getParameter("benIFSC"));
			tm.setBenAmt(Double.parseDouble(request.getParameter("benAmt")));
			String tranDate = df.format(d1);
			System.out.println(tranDate);
			tm.setTranDate(tranDate);
			tm.setStatus("Pending");
			boolean b = tmdi.sendMoney(tm);
			if(b == true)
			{
				request.setAttribute("Success", "Success! Transaction was successful");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Error", "Error! sorry transaction was unsucessful! Please try later!");
				RequestDispatcher rd = request.getRequestDispatcher("sendMoney.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(hiddenAction!=null && hiddenAction.equalsIgnoreCase("searchCustId"))
		{
			String custId = request.getParameter("custId");
			List<TransferMoney> tranList = tmdi.myTransactions(custId);
			request.setAttribute("tranList", tranList);
			RequestDispatcher rd = request.getRequestDispatcher("allTransactions.jsp");
			rd.forward(request, response);
		}
	}

}
