<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Food</title>
	<script>
		function validate()
		{
			var foodName = document.getElementById("food1").value;
			if(foodName =="")
			{
				document.getElementById("foodNameError").innerHTML="Please enter Food Name";
					return false;
			}
			else
			{
					document.getElementById("foodNameError").innerHTML="";
			}
			
			var foodType = document.getElementById("food2").value;
			if(foodType=="")
			{
				document.getElementById("foodTypeError").innerHTML="Please enter Food Type";
				return false;
			}
			else
			{
					document.getElementById("foodTypeError").innerHTML="";
			}
			
			var foodPrice = parseInt(document.getElementById("food3").value);
			if(isNaN(foodPrice))
			{
				document.getElementById("foodPriceError").innerHTML="Please enter Food Price";
				return false;
			}
			else
			{
					document.getElementById("foodPriceError").innerHTML="";
			}
			
			return true;
		}
	</script>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
	<h3 align="center"> Add New Food</h3>
	<form action="CommonFoodServlet" method="post">
	<input type="hidden" name="hiddenAction" value="addFood">
		<table align="center">
			<tr>
				<td> Food Name: </td>
				<td> <input type="text" name="foodName" id=food1> </td>
				<td> <span style="color: red" id=foodNameError> </span> </td>
			</tr>
			<tr>
				<td> Food Type: </td>
				<td> <input type="text" name="foodType" id=food2> </td>
				<td> <span style="color: red" id=foodTypeError> </span> </td>
			</tr>
			<tr>
				<td> Food Price: </td>
				<td> <input type="text" name="foodPrice" id=food3> </td>
				<td> <span style="color: red" id=foodPriceError> </span> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="Add" onclick="return validate()"> </td>
				<td> <input type="reset" value="Clear"> </td>
			</tr>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>

</html>