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

@WebServlet("/TransferMoney")
public class TranferMoney extends HttpServlet {
	BankAccountService bankAccountService = new BankAccountService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String YourAccountid = req.getParameter("YourAccountid");
		String ReceiversAccountid = req.getParameter("ReceiversAccountid");
		String TransferAmount = req.getParameter("TransferAmount");
		long TransferAmount1 = Long.parseLong(TransferAmount);
		int YourAccountid1 = Integer.parseInt(YourAccountid);
		int ReceiversAccountid1 = Integer.parseInt(ReceiversAccountid);
		BankAccount bankAccount1 = bankAccountService.getAccountDetailsById(YourAccountid1);
		BankAccount bankAccount = bankAccountService.transferMoney(YourAccountid1, ReceiversAccountid1,
				TransferAmount1);
		if (bankAccount != null) {
			System.out.println("Transfer Successfull Your remaining Balance Is " + bankAccount.getAccount_balance());
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Your Previous Account Balance is  : "
					+ bankAccount1.getAccount_balance() + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "Your Account Balance is  : " + bankAccount.getAccount_balance()
					+ "</h1></body></html>");
			printWriter.write("<a href='Verified_Customer.jsp'>Back</a>");
			printWriter.write("<br><br>");
		} else {
			System.out.println("Account Not Found or Less Account balance");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Account Not Found or Less Account balance" + "</h1></body></html>");
//			printWriter.write("<br><br>");
//			printWriter.write("<html><body><h1>"+"Name of Manager is :  "+"name"+"</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='Verified_Customer.jsp'>Back</a>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='GetAccountTable.jsp'>Check Account Balance</a>");
		}
	}
}
