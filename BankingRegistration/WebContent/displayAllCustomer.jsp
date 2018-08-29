<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.banking.pojo.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Customers</title>
</head>
<body>
	<%
		String error = (String)request.getAttribute("Error");
		if(error!=null)
			out.print(error);
	%>
	<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	<%
		List<Customer> custList = (List<Customer>)request.getAttribute("custList");
	%>
	<h2 align="center">All Customers</h2>
	<form action="AdminServlet" method="post">
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
				<td>Name</td>
				<td>DOB</td>
				<td>Phone NO</td>
				<td>Email</td>
				<td>Aadhar</td>
				<td>PAN</td>
				<td>Address</td>
				<td>Account No</td>
				<td>Customer Id</td>
				<td>Password</td>
				<td>Transaction Password</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<tr>
				<%
					for(int i=0; i<custList.size(); i++)
					{
						Customer c = custList.get(i);
				%>
			</tr>
			<tr>
				<td> <%=c.getCustName() %> </td>
				<td> <%=c.getCustDOB() %> </td>
				<td> <%=c.getCustPhNo() %> </td>
				<td> <%=c.getCustEmail() %> </td>
				<td> <%=c.getCustAadhar() %> </td>
				<td> <%=c.getCustPAN() %> </td>
				<td> <%=c.getCustAddress() %> </td>
				<td> <%=c.getCustAccNo() %> </td>
				<td> <%=c.getCustId() %> </td>
				<td> <%=c.getCustPassword() %> </td>
				<td> <%=c.getCustTranPassword() %> </td>
				<td> <a href="CustomerServlet?hiddenAction=adminCustEdit&custId=<%=c.getCustId()%>">Edit</a></td>
				<td> <a href="CustomerServlet?hiddenAction=custDelete&custId=<%=c.getCustId()%>">Delete</a> </td>
			</tr>
			<%
					}
			%>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>