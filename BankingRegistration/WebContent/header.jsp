<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tea and Meal - Free CSS Template</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
		String adminLog = (String)session.getAttribute("adminLog");
		String customerLog = (String)session.getAttribute("customerLog");
	%>

	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li class="current"><a href="index.jsp"><b>Home</b></a></li>
   
            <% if(adminLog==null && customerLog==null)
            	{%>
            		<li><a href="login.jsp"><b>Login</b></a> </li>
            		<li> <a href="addCustomer.jsp"><b>Register</b></a> </li>
            	<%} %>
            <% if(adminLog!=null && customerLog==null)
            	{%>
            		<li><a href="AdminServlet?hiddenAction=allCustomer"><b>All Customer</b></a> </li>
            		<li> <a href="AdminServlet?hiddenAction=allAccounts"><b>All Accounts</b> </a> </li>
            		<li> <a href="AdminServlet?hiddenAction=allTransactions"><b>All Transactions</b></a> </li>
            	<%} %>
            <%
            	if(customerLog!=null && adminLog==null)
            	{%>
            		<li> <a href="sendMoney.jsp"><b>Send Money</b></a></li>
            		<li> <a href="TransactionServlet?hiddenAction=myTransactions"><b>My Transactions</b></a></li>
            		<li> <a href="CustomerServlet?hiddenAction=custAccount"><b>My Account</b></a></li>
            		<li> <a href="CustomerServlet?hiddenAction=custEdit"><b>Edit Profile</b></a></li>
            	<%}%>	
            <%
            	if(customerLog!=null || adminLog!=null)
            	{%>
            		<li> <a href="CustomerServlet?hiddenAction=logout"><b>Logout</b></a></li>	
            	<%}%>
           
        </ul>
    </div> <!-- end of menu -->

</body>
</html>