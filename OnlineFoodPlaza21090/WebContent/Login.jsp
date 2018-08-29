<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script>
	function validate()
	{
		var userEmail = document.getElementById("login2").value;
		if(userName=="")
		{
			document.getElementById("userEmailError").innerHTML="Please enter User Email";
			return false;
		}
		else
		{
				document.getElementById("userEmailError").innerHTML="";
		}
		
		var pass = document.getElementById("login3").value;
		if(pass=="")
		{
			document.getElementById("passError").innerHTML="Please enter Password";
			return false;
		}
		else
		{
				document.getElementById("passError").innerHTML="";
		}
		
		return true;
	}
</script>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
	<h3 align="center"> Login </h3>
	<div align="center" style="color: red">
	<%
		String s=(String)request.getAttribute("Error");
    			if(s!=null)
    			{
    				out.print(s);
    			}
    %>
    </div>
	<form action="CommonCustomerServlet" method="post">
	<input type="hidden" name="hiddenAction" value="loginPage">
		<table align="center">
			<tr>
				<td> User: </td>
				<td> <select name="user" id=login1> 
						<option value="Customer">Customer</option> 
					 	<option value="Admin">Admin</option>	
					</select>
				</td>
			</tr>
			<tr>
				<td>User Email: </td>
				<td><input type="text" name="userEmail" id=login2></td>
				<td><span style="color: red" id=userEmailError></span> </td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="pass" id=login3> </td>
				<td><span style="color: red" id=passError> </span> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="Login" onclick="return validate()"> </td>
				<td> <input type="reset" value="Clear"> </td>
			</tr>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>