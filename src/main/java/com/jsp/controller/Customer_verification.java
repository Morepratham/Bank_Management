package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.BankAccount;
import com.jsp.dto.BankCustomer;
import com.jsp.service.BankAccountService;
import com.jsp.service.BankCustomerService;

@WebServlet("/Customer_verification")
public class Customer_verification extends HttpServlet {
	BankCustomerService personService = new BankCustomerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String newpassword = req.getParameter("password");

		int id1 = Integer.parseInt(id);
		BankCustomer person = personService.getPersonById(id1);
		if (person.getCust_password().equals(newpassword)) {
			BankAccountService bankAccountService = new BankAccountService();
			BankAccount bankAccount = bankAccountService.getAccountDetailsById(id1);
			int accountid1 = bankAccount.getAccount_id();
			String accountidString = "" + accountid1;

			Cookie personid = new Cookie("personid", id);
			Cookie accountid = new Cookie("accountid", accountidString);

			resp.addCookie(personid);
			resp.addCookie(accountid);

			resp.addCookie(personid);
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + " Verification is Successfull" + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='Verified_Customer.jsp'> Click here to proceed</a>");
			printWriter.write("<br><br>");
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("id", id1);

		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + " Verification is UnSuccessfull" + " " + id1 + " " + newpassword
					+ "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='Customer_verification.jsp'> Click here to proceed</a>");
			printWriter.write("<br><br>");
		}
	}
}
