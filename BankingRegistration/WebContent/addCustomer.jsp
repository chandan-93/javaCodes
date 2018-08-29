<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
<script type="text/javascript">
	function validate()
	{
		var custName = document.getElementById("custName").value;
		if(custName =="")
		{
			document.getElementById("custNameError").innerHTML="Please enter Customer Name";
			return false;
		}
		else
			document.getElementById("custNameError").innerHTML="";
	
		var custDOB = document.getElementById("custDOB").value;
		if(custDOB=="")
		{
			document.getElementById("custDOBError").innerHTML="Please enter Date of birth";
			return false;
		}
		else
			document.getElementById("custDOBError").innerHTML="";
	
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
		
		var custAadhar = parseInt(document.getElementById("custAadhar").value);
		if(isNaN(custAadhar))
		{
			document.getElementById("custAadharError").innerHTML="Please enter Customer Aadhar no";
			return false;
		}
		else
			document.getElementById("custAadharError").innerHTML="";
		
		var custPAN = document.getElementById("custPAN").value;
		if(custPAN=="")
		{
			document.getElementById("custPANError").innerHTML="Please enter PAN no";
			return false;
		}
		else
			document.getElementById("custPANError").innerHTML="";
		
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
		
		var custId = document.getElementById("custId").value;
		if(custId=="")
		{
			document.getElementById("custIdError").innerHTML="Please create your customer Id";
			return false;
		}
		else
			document.getElementById("custIdError").innerHTML="";
		
		var custAccNo = parceInt(document.getElementById("custAccNo").value);
		if(isNaN(custAccNo))
		{
			document.getElementById("custAccNoError").innerHTML="Please create your customer Id";
			return false;
		}
		else
			document.getElementById("custAccNoError").innerHTML="";
		
		var custPassword = document.getElementById("custPassword").value;
		if(custPassword=="")
		{
			document.getElementById("custPasswordError").innerHTML="Please create your password";
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
			String error = (String)request.getAttribute("Error");
			if(error != null)
				out.print(error);
		%>
	</div>
	<h2 align="center">Add Customer</h2>
	<form action="CustomerServlet" method="post">
	<input type="hidden" name="hiddenAction" value="addCustomer">
		<table align="center">
			<tr>
				<td>Full Name: </td>
				<td> <input type="text" name="custName" id="custName"> </td>
				<td> <span style="color: red" id="custNameError" > </span> </td> 
			</tr>
			<tr>
				<td>Date of Birth (dd/mm/yyyy)</td>
				<td> <input type="text" name="custDOB" id="custDOB"> </td>
				<td> <span style="color: red" id="custDOBError"> </span> </td>
			</tr>
			<tr>
				<td>Phone no: </td>
				<td> <input type ="text" name="custPhNo" id="custPhNo"> </td>
				<td> <span style="color: red" id="custPhNoError"> </span> </td> 
			</tr>
			<tr>
				<td>Email Id: </td>
				<td> <input type="text" name="custEmail" id="custEmail"> </td>
				<td> <span style="color: red" id="custEmailError"> </span> </td>
			</tr>
			<tr>
				<td>Aadhar Id: </td>
				<td> <input type="text" name="custAadhar" id="custAadhar" > </td>
				<td> <span style="color: red" id="custAadharError"> </span> </td>
			</tr>
			<tr>
				<td>PAN Id: </td>
				<td> <input type="text" name="custPAN" id="custPAN"> </td>
				<td> <span style="color: red" id="custPANError"> </span> </td>
			</tr>
			<tr>
				<td>Address: </td>
				<td> <input type="text" name="custAddress" id="custAddress"> </td>
				<td> <span style="color: red" id="custAddressError"> </span> </td>
			</tr>
			<tr>
				<td>Branch: </td>
				<td><input type="text" name="branch" id="branch"> </td>
				<td><span style="color: red" id="branchError"> </span> </td>
			</tr>
			<tr>
				<td>Customer Id: </td>
				<td> <input type="text" name="custId" id="custId"> </td>
				<td> <span style="color: red" id="custIdError"> </span> </td>
			</tr>
			<tr>
				<td>12 Digit Account No: </td>
				<td> <input type="text" name="custAccNo" id="custAccNo"> </td>
				<td> <span style="color: red" id="custAccNoError"> </span> </td>
			</tr>
			<tr>
				<td>Password: </td>
				<td> <input type="Password" name="custPassword" id="custPassword"> </td>
				<td> <span style="color: red" id="custPasswordError"> </span> </td>
			</tr>
			<tr>
				<td>Transaction Password: </td>
				<td> <input type="password" name="custTranPassword" id="custTranPassword"> </td>
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