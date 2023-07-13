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
		<h1>Enter the Managers Details</h1>
		<form action="SaveManager" method="post" id="form">
			Enter Name : <input type="text" name="name"
				placeholder="Enter your name" class="input"> <br> <br>
			Enter your Email :<input type="email" name="email"
				placeholder="Enter your email" class="input"><br> <br>
			Enter your password :<input type="password" name="password"
				placeholder="Enter your password" class="input"><br> <br>
			<input type="submit" placeholder="click here to Submit">
		</form>
	</div>
</body>
</html>