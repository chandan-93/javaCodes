<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.banking.pojo.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
<script type="text/javascript">
function validate()
{	
	var custPhNo = parseInt(document.getElementById("custPhNo").value);
	if(isNaN(custPhNo))
	{
		document.getElementById("custPhNoError").innerHTML="Please enter Customer Phone no.";
		return false;
	}
	else
		document.getElementById("custPhNoError").innerHTML="";
	
	var custEmail = document.getElementById("custEmail").value;
	if(custEmail=="")
	{
		document.getElementById("custEmailError").innerHTML="Please enter email";
		return false;
	}
	else
		document.getElementById("custEmailError").innerHTML="";
	
	var custAddress = document.getElementById("custAddress").value;
	if(custAddress=="")
	{
		document.getElementById("custAddressError").innerHTML="Please enter address";
		return false;
	}
	else
		document.getElementById("custAddressError").innerHTML="";
	
	var branch = document.getElementById("branch").value;
	if(branch=="")
	{
		document.getElementById("branchError").innerHTML="Please enter branch";
		return false;
	}
	else
		document.getElementById("branchError").innerHTML="";
	
	var custPassword = document.getElementById("custPassword").value;
	if(custPassword=="")
	{
		document.getElementById("custPasswordError").innerHTML="Please enter password";
		return false;
	}
	else
		document.getElementById("custPasswordError").innerHTML="";
	
	var custTranPassword = document.getElementById("custTranPassword").value;
	if(custTranPassword=="")
	{
		document.getElementById("custTranPasswordError").innerHTML="Please create your transaction password";
		return false;
	}
	else
		document.getElementById("custTranPasswordError").innerHTML="";
	
	return true;
}
</script>
</head>
<body>
	<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<%
			Customer c = (Customer)request.getAttribute("custProfile");
		
			String error = (String)request.getAttribute("Error");
				if(error!=null)
					out.print(error);
		%>
	</div>
	<h2 align="center">Update Customer</h2>
	<form action="CustomerServlet" method="post">
		<input type="hidden" name="hiddenAction" value="custUpdate">
		<table>
			<tr>
				<td>Full Name: </td>
				<td> <input type="text" value=<%=c.getCustName()%> name="custName" id="custName" readonly> </td>
			</tr>
			<tr>
				<td>DOB: </td>
				<td> <input type="text" value=<%=c.getCustDOB()%> name="custDOB" id="custDOB" readonly> </td>
			</tr>
			<tr>
				<td>Phone No: </td>
				<td> <input type="text" value=<%=c.getCustPhNo()%> name="custPhNo" id="custPhNo"> </td>
				<td> <span style="color: red" id="custPhNoError"> </span> </td>
			</tr>
			<tr>
				<td>Email: </td>
				<td> <input type="text" value=<%=c.getCustEmail()%> name="custEmail" id="custEmail"> </td>
				<td> <span style="color: red" id="custEmailError"> </span> </td>
			</tr>
			<tr>
				<td>Aadhar Id: </td>
				<td> <input type="text" value=<%=c.getCustAadhar()%> name="custAadhar" id="custAadhar" readonly> </td>
			</tr>
			<tr>
				<td>PAN Id: </td>
				<td> <input type="text" value=<%=c.getCustPAN()%> name="custPAN" id="custPAN" readonly> </td>
			</tr>
			<tr>
				<td>Address: </td>
				<td> <input type="text" value=<%=c.getCustAddress()%> name="custAddress" id="custAddress"> </td>
				<td> <span style="color: red" id="custAddressError"> </span> </td>
			</tr>
			<tr>
				<td>Customer Id: </td>
				<td> <input type="text" value=<%=c.getCustId()%> name="custId" id="custId" readonly> </td>
			</tr>
			<tr>
				<td>12 Digit Account No: </td>
				<td> <input type="text" value=<%=c.getCustAccNo()%> name="custAccNo" id="custAccNo" readonly> </td>
			</tr>
			<tr>
				<td>Password: </td>
				<td> <input type="Password" value=<%=c.getCustPassword()%> name="custPassword" id="custPassword"> </td>
				<td> <span style="color: red" id="custPasswordError"> </span> </td>
			</tr>
			<tr>
				<td>Transaction Password: </td>
				<td> <input type="password" value=<%=c.getCustTranPassword() %> name="custTranPassword" id="custTranPassword"> </td>
				<td> <span style="color: red" id="custTranPasswordError"> </span> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="Submit" onclick="return validate()"> </td>
				<td> <input type="reset" value="Clear"> </td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>