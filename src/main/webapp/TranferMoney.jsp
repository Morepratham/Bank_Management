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
			if (cookie.getName().equals("accountid")) {
		personid = cookie.getValue();
		accountid = cookie.getValue();
		break;
			}
		}
	}
	%>
	<form action="TransferMoney" method="post" id="form">
		Enter your Your Account id : <input type="number" class="input"
			name="YourAccountid"
			value="<%=(accountid != null) ? accountid : ""%>"
			readonly="readonly"><br> <br> Enter your Receivers
		Account id : <input type="number" class="input"
			name="ReceiversAccountid"><br> <br> Enter your
		Transfer Amount : <input type="number" class="input"
			name="TransferAmount"><br> <br> <input
			type="submit">
	</form>
</body>
</html>