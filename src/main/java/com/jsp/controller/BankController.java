package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BankController")
public class BankController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Customer = req.getParameter("Customer");
		String Manager = req.getParameter("Manager");
		if (Customer != null) {
			System.out.println(Customer);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CustomerController.jsp");
			requestDispatcher.forward(req, resp);

		} else if (Manager != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("ManagerController.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
