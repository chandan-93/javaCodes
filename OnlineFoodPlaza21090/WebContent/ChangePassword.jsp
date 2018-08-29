<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<script>
	function validate()
	{
		var loginName = document.getElementById("change1").value;
		if(loginName=="")
		{
			document.getElementById("loginEmailError").innerHTML="Please enter Login Name";
			return false;
		}
		else
		{
			document.getElementById("loginEmailError").innerHTML="";
		}
		
		var oldPassword = document.getElementById("change2").value;
		if(oldPassword=="")
		{
			document.getElementById("oldPasswordError").innerHTML="Please enter Old Password";
			return false;
		}
		else
		{
			document.getElementById("oldPasswordError").innerHTML="";	
		}
		
		var newPassword = document.getElementById("change3").value;
		if(newPassword=="")
		{
			document.getElementById("newPasswordError").innerHTML="Please enter new password";
			return false;
		}
		else
		{
			document.getElementById("newPasswordError").innerHTML="";
		}
		
		var confirmPassword = document.getElementById("change4").value;
		if(newPassword != confirmPassword)
		{
			document.getElementById("confirmPasswordError").innerHTML="Please confirm new password";
			return false;
		}
		else
		{
			document.getElementById("confirmPasswordError").innerHTML="";
		}
		return true;
	}
</script>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>

<h3 align="center">Change Password</h3> 
<form action="CommonCustomerServlet" method="post">
<input type="hidden" name="hiddenAction" value="changePassword">
	<table align="center">
		<tr>
			<td> Login Name: </td>
			<td> <input type="text" name="loginEmail" id=change1> </td>
			<td> <span style="color: red" id="loginEmailError"> </span> </td>  
		</tr>
		<tr>
			<td> Old Password: </td>
			<td> <input type="password" name="oldPassword" id=change2> </td>
			<td> <span style="color: red" id="oldPasswordError"> </span> </td>
		</tr>
		<tr>
			<td> New Password: </td>
			<td> <input type="password" name="newPassword" id=change3> </td>
			<td> <span style="color: red" id="newPasswordError"> </span> </td>
		</tr>
		<tr>
			<td> Confirm Password: </td>
			<td> <input type="password" name="confirmPassword" id=change4> </td>
			<td> <span style="color: red" id="confirmPasswordError"> </span> </td>
		</tr>
		<tr>
			<td> <input type="submit" value="Change Password" onclick="return validate()"> </td>
			<td> <input type="reset" value="Clear"> </td>
		</tr>
	</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>