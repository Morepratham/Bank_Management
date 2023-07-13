<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	String personid = null;
	String accountid = null;
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("personid")) {
		personid = cookie.getValue();
		accountid = cookie.getValue();
		break;
			}
		}
	}
	%>
	<form action="Deposit" method="post" id="form">
		Enter Customer id : <input type="number" name="Customerid"
			class="input" placeholder="enter id" readonly="readonly"
			value="<%=(personid != null) ? personid : ""%>"> <br>
		<br> Enter Account id : <input type="number" name="Acconutid"
			class="input" placeholder="enter id"
			value="<%=(accountid != null) ? accountid : ""%>"
			readonly="readonly"> <br> <br> Enter Amount : <input
			type="number" name="EnterAmount" class="input"
			placeholder="Enter Amount"> <br> <br> <input
			type="submit" placeholder="click here to update">
	</form>
</body>
</html>