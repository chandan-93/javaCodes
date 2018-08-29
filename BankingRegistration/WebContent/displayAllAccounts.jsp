<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="com.banking.pojo.AccountDetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Accounts</title>
</head>
<body>
	<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<%
			List<AccountDetails> accList = (List<AccountDetails>)request.getAttribute("accList");
		%>
	</div>
	<h2 align="center">All Accounts</h2>
	<form action="AdminServlet" method="post">
	<input type="hidden" name="hiddenAction" value="searchAccNo">
		<table align="center">
			<tr>
				<td>Search Account No: </td>
				<td><input type="text" name="custAccNo" id="custAccNo"> </td>
				<td><input type="submit" value="Search" onclick=""> </td>
			</tr>
		</table>
	</form>
	<form>
		<table border="1" align="center">
			<tr>
				<td>Customer Id</td>
				<td>Name</td>
				<td>Account No</td>
				<td>Balance</td>
				<td>Branch</td>
				<td>IFSC</td>
			</tr>
			<tr>
				<%
					for(int i=0; i<accList.size(); i++)
					{
						AccountDetails ad = accList.get(i);
				%>
			</tr>
			<tr>
				<td> <%=ad.getCustId()%> </td>
				<td> <%=ad.getCustName()%> </td>
				<td> <%=ad.getCustAccNo() %> </td>
				<td> <%=ad.getCustBalance() %> </td>
				<td> <%=ad.getBranch() %> </td>
				<td> <%=ad.getIFSC() %> </td>
				<td> <a href="AdminServlet?hiddenAction=deleteAccount&custAccNo=<%=ad.getCustAccNo()%>">Delete</a></td>
			</tr>
			<tr>
				<%} %>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>