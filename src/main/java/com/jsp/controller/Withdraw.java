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

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	BankAccountService bankAccountService = new BankAccountService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Customerid = req.getParameter("Customerid");
		String Acconutid = req.getParameter("Acconutid");
		String EnterAmount = req.getParameter("EnterAmount");
		int Customerid1 = Integer.parseInt(Customerid);
		int Acconutid1 = Integer.parseInt(Acconutid);
		long EnterAmount1 = Long.parseLong(EnterAmount);
		BankAccount bankAccount1 = bankAccountService.getAccountDetailsById(Customerid1);
		BankAccount bankAccount = bankAccountService.widthrawMoney(Acconutid1, Customerid1, EnterAmount1);
		if (bankAccount != null) {

			System.out.println(bankAccount.getAccount_balance());
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Your Previous Account Balance is  : "
					+ bankAccount1.getAccount_balance() + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "You Account Balance is  : " + bankAccount.getAccount_balance()
					+ "</h1></body></html>");

		} else {
			System.out.println("Account Not Found");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Account Not found  : " + "</h1></body></html>");
		}
	}
}
