<%@page import="com.jsp.dto.Bank"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.BankService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="table">
		<%
		BankService bankService = new BankService();
		%>
		<%
		List<Bank> banks = bankService.getAllBanks();
		%>
		<table border="2px">
			<tr>
				<th>Bank_ID</th>
				<th>Bank_NAME</th>
				<th>Bank_City</th>
			</tr>
			<%
			for (Bank b : banks) {
				if (b.getBank_name() != null) {
			%>
			<tr>
				<td><%=b.getBank_id()%></td>
				<td><%=b.getBank_name()%></td>
				<td><%=b.getBank_city()%></td>

			</tr>
			<%
			}
			}
			%>
		</table>
	</div>
	<br>
	<br>
	<div id="h1">
		<h1>Enter the Customers Details</h1>
	</div>
	<div id="form">
		<form action="SaveAccount" method="post">
			Enter your Bank id : <input type="number" class="input" name="bankid"
				placeholder="Enter your Bank id"> <br> <br> Enter
			Customer id : <input type="number" class="input" name="id"> <br>
			<br> Enter your Opening Balance :<input type="number"
				name="OpeningBalance" class="input"
				placeholder="Enter your Opening Balance"><br> <br>
			<h3>Enter Type Account :</h3>
			<br> <br> Saving<input type="radio" name="Type"
				value="Saving"> Current <input type="radio" name="Type"
				value="Current"> <br>
			<br> <input type="submit" placeholder="click here to Submit">
		</form>
</body>
</html>