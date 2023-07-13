<%@page import="com.jsp.service.BankService"%>
<%@page import="com.jsp.dto.Bank"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<%BankService bankService = new BankService();%>
		<%Bank bank = bankService.getBankByid(1);%>
		<h1>
			Welcome To
			<%=bank.getBank_name()%>
		</h1>
		

			<form action="Login" method="post">
				Click here if your a Customer : <input type="submit" name="Customer"
					placeholder="Click here if your a customer"><br>
				<br> Click here if your a Manager : <input type="submit"
					name="Manager" placeholder="Click here if your a manager"><br>
				<br>
			</form>
</body>
</html>