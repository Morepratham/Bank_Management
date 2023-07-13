package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Bank;
import com.jsp.service.BankService;

@WebServlet("/UpdateBank")
public class UpdateBank extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankService bankService = new BankService();
		String name = req.getParameter("Bank_name");
		String city = req.getParameter("City");
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		Bank bank = bankService.getBankByid(id1);
		bank.setBank_name(name);
		bank.setBank_city(city);
		Bank bank2 = bankService.updateBank(id1, bank);

		if (bank2 != null) {
			System.err.println("=======================================");
			System.out.println("Updated Bank " + bank2.getBank_name());
			System.err.println("=======================================");
			PrintWriter printWriter = resp.getWriter();
			printWriter
					.write("<html><body><h1>" + "You have Selected : " + bank2.getBank_name() + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "Your Branch is : " + bank2.getBank_city() + "</h1></body></html>");

		} else {
			System.err.println("=======================================");
			System.out.println("Bank Not Found");
			System.err.println("=======================================");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Wrong Input " + "</h1></body></html>");
		}
	}
}
