<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!--  Free CSS Template by TemplateMo.com  --> 
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li class="current"><a href="index.jsp"><b>Home</b></a></li>
            <li><a href="CommonFoodServlet"><b>Food Menu</b></a></li>
   
            <% if(adminLog==null && customerLog==null)
            	{%>
            		<li><a href="Login.jsp"><b>Login</b></a> </li>
            		<li> <a href="AddCustomer.jsp"><b>Register</b></a> </li>
            	<%} %>
            <% if(adminLog!=null && customerLog==null)
            	{%>
            		<li><a href="CommonCustomerServlet"><b>Show Customer</b></a> </li>
            		<li> <a href="AddFood.jsp"><b>Add Food</b> </a> </li>
            		<li> <a href="ChangePassword.jsp"><b>Change Password</b></a> </li>
            		<li> <a href="CommonCustomerServlet?hiddenAction=feedBackList"><b>FeedBacks</b> </a> </li>
            	<%} %>
            <%
            	if(customerLog!=null && adminLog==null)
            	{%>
            		<li> <a href="CommonCustomerServlet?hiddenAction=editProfile"><b>Edit Profile</b></a></li>
            		<li> <a href="CommonFoodServlet?hiddenAction=showCart"><b>Cart</b></a></li>
            		<li> <a href="order.jsp"><b>Order</b></a></li> 
            		<li> <a href="CommonCustomerServlet?hiddenAction=contactUs"><b>Contact Us</b></a></li>
            	<%}%>	
            <%
            	if(customerLog!=null || adminLog!=null)
            	{%>
            		<li> <a href="CommonCustomerServlet?hiddenAction=logout"><b>Logout</b></a></li>	
            	<%}%>
           
        </ul>
    </div> <!-- end of menu -->

</body>
</html>