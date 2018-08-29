<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<%
			String s = (String)request.getAttribute("Error");
			if(s!=null)
				out.print(s);
		%>
	</div>
	<h2 align="center">Login</h2>
	<form action="CustomerServlet" method="post">
		<input type="hidden" name="hiddenAction" value="login">
		<table align="center">
			<tr>
				<td>Select: </td>
				<td> <select name="user" id="user">
					<option value="customer">Customer</option>
					<option value="admin">Admin</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>User Id: </td>
				<td> <input type="text" name="userId" id="userId"> </td>
				<td> <span style="color: red" id="usernameError"> </span> </td>
			</tr>
			<tr>
				<td>Password: </td>
				<td> <input type="password" name="userPassword" id="userPassword"> </td>
				<td> <span style="color: red" id="userPasswordError"> </span> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="Submit"> </td>
				<td> <input type="reset" value="Clear"> </td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>