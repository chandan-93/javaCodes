<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.banking.pojo.TransferMoney" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Transactions</title>
</head>
<body>
	<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<%
			List<TransferMoney> tranList = (List<TransferMoney>)request.getAttribute("tranList");
		%>
	</div>
	<h2 align="center">All Transactions</h2>
	<form action="TransactionServlet" method="post">
	<input type="hidden" name="hiddenAction" value="searchCustId">
		<table align="center">
			<tr>
				<td>Search CustomerId: </td>
				<td><input type="text" name="custId" id="custId"> </td>
				<td><input type="submit" value="Search" onclick=""> </td>
			</tr>
		</table>
	</form>
	<form>
		<table border="1" align="center">
			<tr>
				<td>Customer Id</td>
				<td>Beneficiary Name</td>
				<td>Beneficiary Account No</td>
				<td>Beneficiary Bank</td>
				<td>Beneficiary IFSC</td>
				<td>Amount Sent</td>
				<td>TransactionDate</td>
				<td>Transaction Status</td>
			</tr>
			<tr>
				<% 
					for(int i=0; i<tranList.size(); i++)
					{
						TransferMoney tm = tranList.get(i);
				%>
			</tr>
			<tr>
				<td><%=tm.getCustId() %> </td>
				<td><%=tm.getBenName() %> </td>
				<td><%=tm.getBenAccNo() %> </td>
				<td><%=tm.getBenBank() %> </td>
				<td><%=tm.getBenIFSC() %> </td>
				<td><%=tm.getBenAmt() %> </td>
				<td><%=tm.getTranDate() %> </td>
				<td><%=tm.getStatus() %> </td>
				<td><a href="TransactionServlet?hiddenAction=approveTran&custId=<%=tm.getCustId() %>">Approve</a> </td>
				<td><a href="TransactionServlet?hiddenAction=deleteTran&custId=<%=tm.getCustId() %>">Delete</a> </td>
			</tr>
				<% } %>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>