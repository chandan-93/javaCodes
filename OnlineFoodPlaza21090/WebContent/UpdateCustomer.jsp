<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
     <%@ page import="com.foodplaza.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Customer</title>
<script>
	function validate()
	{
		var custName = document.getElementById("cust1").value;
		if(custName =="")
		{
			document.getElementById("custNameError").innerHTML="Please enter Customer Name";
			return false;
		}
		
		var custPhno = parseInt(document.getElementById("cust2").value);
		if(isNaN(custPhno))
		{
			document.getElementById("custPhnoError").innerHTML="Please enter Customer Phone no.";
			return false;
		}
		
		var custAddress = document.getElementById("cust3").value;
		if(custAddress=="")
		{
			document.getElementById("custAddressError").innerHTML="Please enter Customer Address";
			return false;
		}
		
		var custEmail = document.getElementById("cust4").value;
		if(custEmail=="")
		{
			document.getElementById("custEmailError").innerHTML="Please enter Customer Email";
			return false;
		}
		
		var custPass = document.getElementById("cust5").value;
		if(custPass=="")
		{
			document.getElementById("custPassError").innerHTML="Please enter a Password";
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<% Customer c = (Customer)request.getAttribute("customerList"); %>
	<h3 align="center"> Update Customer </h3>
	
	<div align="center" style="color: green"> 
	<% 	String s = (String)request.getAttribute("Error");
		if(s!=null)
			out.print(s);
	%>
	</div>
	
	<form action="CommonCustomerServlet" method="post">
	<input type="hidden" name="hiddenAction" value="updateCustomer">
		<table align="center">
			<tr>
				<td>Customer Id: </td>
				<td> <input type="text" value=<%=c.getCustId() %> name="custId" id=cust0 readonly> </td>
		
			</tr>
			<tr>
				<td> Name: </td>
				<td> <input type="text" value=<%=c.getCustName() %> name="custName" id=cust1> </td>
				<td> <span style="color: red" id="custNameError"> </span> </td>
			</tr>
			<tr>
				<td> Phone No. : </td>
				<td> <input type="text" value=<%=c.getCustPhno() %> name="custPhno" id=cust2> </td>
				<td> <span style="color: red" id="custPhnoError"> </span>
			</tr>
			<tr>
				<td> Address: </td>
				<td> <input type="text" value=<%=c.getCustAddress() %> name="custAddress" id=cust3> </td>
				<td> <span style="color: red" id="custAddressError"> </span> </td>
			</tr>
			<tr>
				<td> Email: </td>
				<td> <input type="text" value=<%=c.getCustEmail() %> name="custEmail" id=cust4> </td>
				<td> <span style="color: red" id="custEmailError"> </span> </td>
			</tr>
			<tr>
				<td> Password: </td>
				<td> <input type="password" value=<%=c.getCustPassword() %> name="custPass" id=cust5> </td>
				<td> <span style="color: red" id="custPassError"> </span> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="Add" onclick="return validate()"> </td>
				<td> <input type="reset" value="Clear"> </td>
			</tr>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>