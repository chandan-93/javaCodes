<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%@page import="com.foodplaza.pojo.*"%>
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
	<% List<FeedBack> l = (List<FeedBack>)request.getAttribute("allFeedBack");%>
	<form>
		<table align="center">
		<tr>
				<% for(int i=0; i<l.size(); i++)
					{
						FeedBack fb = l.get(i);
					
				%>
			</tr>
			<tr>
				<th> Customer Name </th>
				<th> Customer Phno </th>
				<th> Customer Email </th>
				<th> Customer Message </th>
			</tr>
			
			<tr>
	
				<td> <%=fb.getName()%> </td>
				<td> <%=fb.getCustEmail()%></td>
				<td> <%=fb.getPhno() %> </td>
				<td> <%=fb.getMsg() %> </td>
			</tr>
			<%} %>
		</table>
	</form>

<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>