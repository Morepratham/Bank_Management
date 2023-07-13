<%@page import="java.io.PrintWriter"%>
<%@page import="com.jsp.service.BankCustomerService"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.dto.BankCustomer"%>

<%@page import="com.jsp.service.BankManagerService"%>

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
	BankManagerService managerService = new BankManagerService();
	BankCustomerService personService = new BankCustomerService();
	%>
	<%
	List<BankCustomer> persons = managerService.viewAllPerson();
	%>
	<table border="2px" id="table">
		<tr>
			<th>Customer_ID</th>
			<th>Customer_NAME</th>
			<th>Customer_Email</th>
			<th>Customer_Status</th>
			<th>APPROVE</th>
			<th>BLOCK</th>

		</tr>
		<%
		for (BankCustomer p : persons) {
		%>

		<tr>
			<td><%=p.getCust_id()%></td>
			<td><%=p.getCust_name()%></td>
			<td><%=p.getCust_email()%></td>
			<td><%=p.getCust_status()%></td>
			<td><a href="Approve.jsp?id=<%=p.getCust_id()%>">APPROVE</a></td>
			<td><a href="Block.jsp?id=<%=p.getCust_id()%>">BLOCK</a></td>

		</tr>
		<%
		}
		%>

	</table>
	<br>
	<br>
	<br>
	<br>
	<div>
		<%
		PrintWriter printWriter = response.getWriter();
		printWriter.write("<br><br>");
		printWriter.write("<a href='BankController.jsp'>Main Menu</a>");
		printWriter.write("<br><br>");
		printWriter.write("<a href='ManagerController.jsp'>Back</a>");
		%>
	</div>
</body>
</html>