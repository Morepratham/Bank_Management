<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Block" method="post" id="form">
Customer ID : <input type="number" name="CustomerId"  value="<%= request.getParameter("id")%>" class="input"> <br> <br>

Enter Manager Id : <input type="number"  name="ManagerId" class="input"><br> <br>

<input type="submit">
</form>
</body>
</html>