<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.banking.pojo.TransferMoney" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Transactions</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	<%
		List<TransferMoney> myTranList = (List<TransferMoney>)request.getAttribute("myTranList");
	%>
	<h2 align="center">My Transactions</h2>
	<form>
		<table align="center" border="1">
			<tr>
				<td>Beneficiary Name</td>
				<td>Beneficiary Account No</td>
				<td>Beneficiary Bank</td>
				<td>Beneficiary IFSC</td>
				<td>Amount Sent</td>
				<td>Date</td>				
				<td>Transaction Status</td>
			</tr>
			<tr>
				<%
					for(int i=0; i < myTranList.size(); i++)
					{
						TransferMoney tm = myTranList.get(i);
				%>
			</tr>
			<tr>
				<td> <%=tm.getBenName()%> </td>
				<td> <%=tm.getBenAccNo() %> </td>
				<td> <%=tm.getBenBank() %> </td>
				<td> <%=tm.getBenIFSC() %> </td>
				<td> <%=tm.getBenAmt() %> </td>
				<td> <%=tm.getTranDate() %> </td>
				<td> <%=tm.getStatus() %> </td>
			</tr>
			<% } %>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>