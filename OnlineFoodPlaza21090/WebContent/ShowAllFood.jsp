<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
    <%@ page import="com.foodplaza.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Food</title>
</head>

<body>

<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<h3 align="center">All Food </h3>
	<% List<Food> l = (List<Food>)request.getAttribute("foodList");
		String adminLog = (String)session.getAttribute("adminLog");
		String customerLog = (String)session.getAttribute("customerLog");
	%>
	
	<div align="center" style="color: green">
	<%	String s = (String)request.getAttribute("Success");
		if(s!=null)
			out.print(s);
	%>
	</div>
	<form>
		<table align="center">
			<tr>
				<th> Food Id </th>
				<th> Food Name </th>
				<th> Food Price </th>
				<th> Food Type </th>
			</tr>
			<tr>
				<% for(int i=0; i<l.size(); i++)
					{
						Food f = l.get(i);
					
				%>
			</tr>
			<tr>
				<td> <%=f.getFoodId() %> </td>
				<td> <%=f.getFoodName()%> </td>
				<td> <%=f.getFoodPrice() %></td>
				<td> <%=f.getFoodType()%> </td>
				<% if(adminLog!=null && customerLog==null)
				{%>
				<td> <a href="CommonFoodServlet?hiddenAction=edit&ID=<%=f.getFoodId()%>"> Edit </a> </td>
				<td> <a href="CommonFoodServlet?hiddenAction=delete&ID=<%=f.getFoodId()%>">Delete </a> </td>
				<%} %>
				<% if(customerLog!=null && adminLog==null)
				{%>
				<td> <input type="number" name="qty" min="1" max="10">Enter Qty</td>
				<td> <a href="CommonFoodServlet?hiddenAction=addToCart&ID=<%=f.getFoodId()%>">Add to cart</a> </td>
				<%} %>
			</tr>
			<%} %>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>