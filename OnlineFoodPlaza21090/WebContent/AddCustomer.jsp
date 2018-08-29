<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Customer</title>
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
	<h3 align="center"> Add New Customer </h3>
	<div align="center" style="color: red">
		<%
			String s = (String)request.getAttribute("Error");
			if(s!=null)
				out.print(s);
		%>
	</div>
	<form action="CommonCustomerServlet" method="post">
	<input type="hidden" name="hiddenAction" value="addCustomer">
		<table align="center">
			<tr>
				<td> Name: </td>
				<td> <input type="text"  name="custName" id=cust1 required> </td>
				<td> <span style="color: red" id="custNameError"> </span> </td>
			</tr>
			<tr>
				<td> Phone No. : </td>
				<td> <input type="text" name="custPhno" id=cust2 required> </td>
				<td> <span style="color: red" id="custPhnoError"> </span>
			</tr>
			<tr>
				<td> Address: </td>
				<td> <input type="text" name="custAddress" id=cust3 required> </td>
				<td> <span style="color: red" id="custAddressError"> </span> </td>
			</tr>
			<tr>
				<td> Email: </td>
				<td> <input type="email" name="custEmail" id=cust4 required> </td>
				<td> <span style="color: red" id="custEmailError"> </span> </td>
			</tr>
			<tr>
				<td> Password: </td>
				<td> <input type="password" name="custPass" id=cust5 required> </td>
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