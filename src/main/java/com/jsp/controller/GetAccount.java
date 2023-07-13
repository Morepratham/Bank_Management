package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.BankAccount;
import com.jsp.service.BankAccountService;

@WebServlet("/GetAccount")
public class GetAccount extends HttpServlet {
	BankAccountService bankAccountService = new BankAccountService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("Customerid");
		int id1 = Integer.parseInt(id);
		BankAccount bankAccount = bankAccountService.getAccountDetailsById(id1);

		if (id1 != 0) {
			System.out.println(bankAccount.getAccount_id() + " " + bankAccount.getAccount_number() + " "
					+ bankAccount.getAccount_balance() + " " + bankAccount.getAccount_type());
			PrintWriter printWriter = resp.getWriter();
			printWriter.write(
					"<html><body><h1>" + "You Account_id is  : " + bankAccount.getAccount_id() + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "You Account_number is  : " + bankAccount.getAccount_number()
					+ "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "You Account Balance is  : " + bankAccount.getAccount_balance()
					+ "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "You Account Type is  : " + bankAccount.getAccount_type()
					+ "</h1></body></html>");
			printWriter.write(
					"<html><body><h1><table border=2px ><tr><th>Account_id</th><th>Account_number</th><th>Account Balance"
							+ "</th><th>Account Type</th></tr><br><tr><th>" + bankAccount.getAccount_id() + "</th><th>"
							+ bankAccount.getAccount_number() + "</th><th>" + bankAccount.getAccount_balance()
							+ "</th><th>	" + bankAccount.getAccount_type()
							+ " </th></tr></table></h1></body></html>");
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Account Not found  : " + "</h1></body></html>");
		}
	}
}
