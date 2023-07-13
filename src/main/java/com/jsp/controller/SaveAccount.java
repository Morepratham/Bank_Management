package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.BankAccount;
import com.jsp.service.BankAccountService;
import com.jsp.service.BankService;

@WebServlet("/SaveAccount")
public class SaveAccount extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankAccountService bankAccountService = new BankAccountService();
		BankService bankService = new BankService();
		BankAccount account = new BankAccount();
//		String AccountNumber = req.getParameter("AccountNumber");
		String bankid = req.getParameter("bankid");
		String id = req.getParameter("id");

		String OpeningBalance = req.getParameter("OpeningBalance");
		String Type = req.getParameter("Type");
		int id1 = Integer.parseInt(id);
		int bankid1 = Integer.parseInt(bankid);
		double OpeningBalance1 = Double.parseDouble(OpeningBalance);
//		long AccountNumber1 = Long.parseLong(AccountNumber);
		account.setBank(bankService.getBankByid(bankid1));
//		account.setAccount_number(AccountNumber1);
		account.setAccount_balance(OpeningBalance1);
		account.setAccount_type(Type);
		ArrayList<BankAccount> bankAccounts = new ArrayList<>();
		bankAccounts.add(account);
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("id1", bankid1);
		BankAccount bankAccount = bankAccountService.saveBankAccountById(id1, account);
		if (bankAccount != null) {
			System.out.println(bankAccount.getAccount_id() + " " + bankAccount.getAccount_number() + " "
					+ bankAccount.getAccount_balance());
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "You Account is Opened " + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "Your Id is : " + bankid1 + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='GetAccountTable.jsp'>To Check Balance</a>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='Deposit.jsp'>To Add money</a>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='Withdraw.jsp'>To Withdraw money</a>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='CustomerController.jsp'>back</a>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='BankController.jsp'>Main Menu</a>");
//			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CustomerController.jsp");
//			requestDispatcher.forward(req, resp);
		}
	}
}
