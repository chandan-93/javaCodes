<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
    <%@ page import="com.foodplaza.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Customer</title>
</head>

<body>

<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<h3 align="center">All Customer </h3>
<% List<Customer> l = (List<Customer>)request.getAttribute("customerList");%>
	<form>
		<table align="center">
			<tr>
				<th> Customer Id </th>
				<th> Customer Name </th>
				<th> Customer Phno </th>
				<th> Customer Address </th>
				<th> Customer Email </th>
				<th> Customer Password </th>
			</tr>
			<tr>
				<% for(int i=0; i<l.size(); i++)
					{
						Customer c = l.get(i);
					
				%>
			</tr>
			<tr>
				<td> <%=c.getCustId() %> </td>
				<td> <%=c.getCustName()%> </td>
				<td> <%=c.getCustPhno() %></td>
				<td> <%=c.getCustAddress()%> </td>
				<td> <%=c.getCustEmail() %> </td>
				<td> <%=c.getCustPassword() %> </td>
				<td> <a href="CommonCustomerServlet?hiddenAction=edit&ID=<%=c.getCustId()%>"> Edit </a> </td>
				<td> <a href="CommonCustomerServlet?hiddenAction=delete&ID=<%=c.getCustId()%>">Delete </a> </td>
			</tr>
			<%} %>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>