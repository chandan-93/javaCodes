<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodplaza.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
	<%Customer c = (Customer)request.getAttribute("feedBackForm");%>
	<form action="CommonCustomerServlet" method="post">
	<input type="hidden" name="hiddenAction" value="sendFeedBack">
		<table align="center">
			<tr>
				<td>Name: </td>
				<td> <input type="text" name="custName" id="custName" value="<%=c.getCustName()%>" readonly> </td>
			</tr>
			<tr>
				<td>Email: </td>
				<td> <input type="text" name="custEmail" id="custEmail" value="<%=c.getCustEmail()%>" readonly> </td>
			</tr>
			<tr>
				<td>Phno: </td>
				<td><input type="text" name="phno" id="phno" value="<%=c.getCustPhno()%>" readonly> </td>
			</tr>
			<tr>
				<td>Message</td>
				<td><textarea rows="10" cols="30" name="msg" id="msg" > </textarea> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="Send"> </td>
				<td> <input type="reset" value="Clear"> </td>
			</tr>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>