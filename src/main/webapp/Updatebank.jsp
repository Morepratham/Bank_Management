<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter the Data to be updated</h1>
	<form action="UpdateBank" method="post">
		Enter Bank id : <input type="number" name="id" placeholder="enter id">
		<br> <br> Name :<input type="text" name="Bank_name"
			placeholder="Enter the  name"><br> <br> City :<input
			type="text" name="City" placeholder="Enter the  city"><br>
		<br> <input type="submit" placeholder="click here to update">
	</form>
</body>
</html>