package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.BankCustomer;
import com.jsp.service.BankCustomerService;

@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	BankCustomerService personService = new BankCustomerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String new_password = req.getParameter("new_password");

		BankCustomer person = personService.getPersonById(id);
		person.setCust_name(name);
		person.setCust_email(email);
		person.setCust_password(new_password);
		BankCustomer person2 = personService.updatePersonById(id, person);
		if (person2 != null) {
			System.err.println("=======================================");
			System.out.println("Customer Details Are updated " + person2.getCust_name());
			System.err.println("=======================================");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write(
					"<html><body><h1>" + "You Details are Updated : " + person2.getCust_name() + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "Your Id is : " + person2.getCust_id() + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='CustomerController.jsp'> Click here to proceed</a>");
			printWriter.write("<br><br>");
		} else {
			System.err.println("=======================================");
			System.out.println("Customer Not Found");
			System.err.println("=======================================");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Wrong Input " + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='CustomerController.jsp'> Click here to proceed</a>");
			printWriter.write("<br><br>");
		}
	}
}
