<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateCustomer" method="post" id="form">
		Enter Customer id : <input type="number" name="id"
			placeholder="enter id" class="input"> <br> <br>
		Name :<input type="text" name="name" placeholder="Enter the  name"
			class="input"><br> <br> Email :<input type="email"
			name="email" placeholder="Enter the  email" class="input"><br>
		<br> Enter your Old Password :<input type="password"
			name="old_password" placeholder="Enter your password" class="input"><br>
		<br> Enter your New Password :<input type="password"
			name="new_password" placeholder="Enter your password" class="input"><br>
		<br> <input type="submit" placeholder="click here to update">
	</form>
</body>
</html>