<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.banking.pojo.AccountDetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Account</title>
</head>
<body>
	<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<%
			AccountDetails ad = (AccountDetails)request.getAttribute("myAccount");
		%>
	</div>
	<h2 align="center">My Account</h2>
	<form action="CustomerServlet" method="post">
		<table align="center">
			<tr>
				<td>Customer Id: </td> 
				<td> <%=ad.getCustId()%> </td>
			</tr>
			<tr>
				<td>Name: </td>
				<td> <%=ad.getCustName()%> </td>
			</tr>
			<tr>
				<td>Account No: </td>
				<td> <%=ad.getCustAccNo()%>
			</tr>
			<tr>
				<td>Balance: </td>
				<td> <%=ad.getCustBalance()%>
			</tr>
			<tr>
				<td>Bank: </td>
				<td> <%=ad.getBank()%> </td>
			</tr>
			<tr>
				<td>Branch: </td>
				<td> <%=ad.getBranch() %> </td>
			</tr>
			<tr>
				<td>IFSC: </td>
				<td> <%=ad.getIFSC() %> </td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>