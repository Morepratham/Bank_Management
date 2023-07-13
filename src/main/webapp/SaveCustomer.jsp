<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Enter the Customers Details</h1>
		<form action="SaveCustomer" method="post">
			Enter Name : <input type="text" name="name"
				placeholder="Enter your name"> <br> <br> Enter
			your Email :<input type="email" name="email"
				placeholder="Enter your email"><br> <br> Enter
			your Password :<input type="password" name="password"
				placeholder="Enter your password"><br> <br> Male<input
				type="radio" name="gender" value="male"> Female <input
				type="radio" name="gender" value="female"> <br>
			<br> Enter Pan Number : <input type="text" name="Pan"
				placeholder="Enter your Pan Number"> <br> <br> <input
				type="submit" placeholder="click here to Submit">
		</form>
	</div>
	<%
	/*
	Gender : <input type="checkbox" name="gender" value="Male"> <br> <br>
	Gender : <input type="checkbox" name="gender" value="Female"> <br> <br>
	Status : <input type="checkbox" name="Status" value="Approved"> <br> <br>
	Status : <input type="checkbox" name="Status" value="UaApproved"> <br> <br>*/
	%>
</body>
</html>