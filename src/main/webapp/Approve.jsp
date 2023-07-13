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
	String managerid = null;
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("managerid")) {
		managerid = cookie.getValue();
		break;
			}
		}
	}
	%>
	<form action="Approve" method="post" id="form">
		Customer ID : <input type="number" name="CustomerId"
			value="<%=request.getParameter("id")%>" class="input"> <br>
		<br> Enter Manager Id: <input type="number" name="ManagerId"
			class="input" readonly="readonly"
			value="<%=(managerid != null) ? managerid : ""%>"><br>
		<br> <input type="submit">
</body>
</html>