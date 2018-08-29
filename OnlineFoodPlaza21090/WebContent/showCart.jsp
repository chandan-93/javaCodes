<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodplaza.pojo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
	<% List<Cart> l = (List<Cart>)request.getAttribute("cart"); %>
	<%String s = (String)request.getAttribute("Success");
		if(s!=null)
			out.print(s);
	%>
<form action="CommonFoodServlet" method="post">
<input type="hidden" name="hiddenAction" value="placeOrder">
<table align="center">
<tr>
	<td>Food Name: </td>
	<td>Food Price: </td>
	<td>Food Qty: </td>
	<td>Delete Food: </td>
</tr>

<tr>
<% for(int i=0; i<l.size(); i++)
	{
		Cart ct = l.get(i);
%>
</tr>
<tr>
	<td> <%=ct.getFoodName() %> </td>
	<td> <%=ct.getFoodPrice() %> <input type="hidden" name="foodPrice" id="foodPrice"></td>
	<td> <input type="text" name="qty" id="qty"></td>
	<td> <a href="CommonFoodServlet?hiddenAction=deleteCart&ID=<%=ct.getCartId()%>">Delete </a> </td>
</tr>	
<%} %>
<tr>
	<td><input type="submit" value="Place Order"></td>
</tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>