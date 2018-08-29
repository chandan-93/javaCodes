<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Money</title>
<script type="text/javascript">
function validate()
{
	
	var benName = document.getElementById("benName").value;
	if(benName=="")
	{
		document.getElementById("benNameError").innerHTML="Please enter beneficiary name";
		return false;
	}
	else
		document.getElementById("benNameError").innerHTML="";
	
	var benAccNo = parseInt(document.getElementById("benAccNo").value);
	if(isNaN(benAccNo))
	{
		document.getElementById("benAccNoError").innerHTML="Please enter beneficiary account no";
		return false;
	}
	else
		document.getElementById("benAccNoError").innerHTML="";
	
	
	var benBank = document.getElementById("benBank").value;
	if(benBank=="")
	{
		document.getElementById("benBankError").innerHTML="Please enter beneficiary bank";
		return false;
	}
	else
		document.getElementById("benBankError").innerHTML="";
	
	var benIFSC = document.getElementById("benIFSC").value;
	if(benIFSC=="")
	{
		document.getElementById("benIFSCError").innerHTML="Please enter beneficiary branch";
		return false;
	}
	else
		document.getElementById("benIFSCError").innerHTML="";
	
	var benAmt = parseInt(document.getElementById("benAmt").value);
	if(isNaN(benAmt))
	{
		document.getElementById("benAmtError").innerHTML="Please enter beneficiary amount";
		return false;
	}
	else
		document.getElementById("benAmtError").innerHTML="";
	
	return true;
}

</script>
</head>
<body>
	<div id="templatemo_container">
	<jsp:include page="header.jsp"></jsp:include>
	<h2 align="center">Add beneficiary account details</h2>
	<form action="TransactionServlet" method="post">
		<input type="hidden" name="hiddenAction" value="transferMoney">
		<table align="center">
			<tr>
				<td>Beneficiary Name: </td>
				<td> <input type="text" name="benName" id="benName"> </td>
				<td> <span style="color: red" id="benNameError"> </span> </td>
			</tr>
			<tr>
				<td>Beneficiary Account No: </td>
				<td> <input type="text" name="benAccNo" id="benAccNo"> </td>
				<td> <span style="color: red" id="benAccNoError"> </span> </td>
			</tr>
			<tr>
				<td>Beneficiary Bank: </td>
				<td> <input type="text" name="benBank" id="benBank"> </td>
				<td> <span style="color: red" id="benBankError"> </span> </td>
			</tr>
			<tr>
				<td>Beneficiary IFSC: </td>
				<td> <input type="text" name="benIFSC" id="benIFSC"> </td>
				<td> <span style="color: red" id="benIFSCError"> </span> </td>
			</tr>
			<tr>
				<td>Beneficiary Amount: </td>
				<td> <input type="text" name="benAmt" id="benAmt"> </td>
				<td> <span style="color: red" id="benAmtError"> </span> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="Submit" onclick="return validate()">
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>