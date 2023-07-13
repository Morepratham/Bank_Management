<%@page import="com.jsp.dto.Bank"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.BankService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="main" class="container">
  <form action="SaveBank" method="post" id="form">
    <label for="bankname">Enter Bank Name :</label>
    <input type="text" name="BankName" id="bankname" placeholder="Bank Name" required><br><br>
    <label for="banklocation">Enter Branch Location :</label>
    <input type="text" name="BranchLocation" id="banklocation" placeholder="Branch Location" required><br><br>
    <input type="submit" value="Submit" id="submit">
  </form>
</div>
</body>
</html>