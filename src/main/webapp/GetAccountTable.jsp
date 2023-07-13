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
            accountid=cookie.getValue();
            break;
        }
    }
}
%>
<form action="GetAccount" method="post" id="form">
Enter Customer id : <input type="number" class="input" name="Customerid" placeholder="enter id" readonly="readonly" value="<%= (personid != null) ? personid : "" %>"> <br> <br>
<input type="submit" placeholder="click here to get data">
</form>
</body>
</html>