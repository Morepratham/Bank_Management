package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Bank;
import com.jsp.service.BankManagerService;
import com.jsp.service.BankService;

@WebServlet("/SaveBank")
public class SaveBank extends HttpServlet {
	BankService bankService = new BankService();
	BankManagerService managerService = new BankManagerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bank bank = new Bank();
		String name = req.getParameter("BankName");
		String BranchLocation = req.getParameter("BranchLocation");
		bank.setBank_name(name);
		bank.setBank_city(BranchLocation);
		bank.setBankmanagers(managerService.getAllManagers());
		Bank bank1 = bankService.saveBankDetails(bank);

		if (bank1 != null) {
			System.out.println("================================================");
			System.out.println(bank.getBank_name() + " " + bank.getBank_city() + " " + bank.getBank_id());
			System.out.println("============================");
			PrintWriter printWriter = resp.getWriter();
			printWriter
					.write("<html><body><h1>" + "You have Selected : " + bank1.getBank_name() + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "Your Branch is : " + bank1.getBank_city() + "</h1></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(req, resp);
			printWriter.write("<a href='Login.jsp'>Click here to Proceed further</a>");
			printWriter.write("<br><br>");
		} else {
			PrintWriter printWriter = resp.getWriter();
			System.out.println("============================");
			System.out.println("Bank not saved");
			System.out.println("============================");
			printWriter.write("<html><body><h1>" + "Wrong Input " + "</h1></body></html>");
		}
	}
}
