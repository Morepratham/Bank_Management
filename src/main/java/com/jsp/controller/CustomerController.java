package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Save = req.getParameter("Save");
		String Customer_verification = req.getParameter("Customer_verification");

		if (Save != null) {
			System.out.println(Save);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("SaveCustomer.jsp");
			requestDispatcher.forward(req, resp);
		} else if (Customer_verification != null) {
			System.out.println(Customer_verification);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Customer_verification.jsp");
			requestDispatcher.forward(req, resp);
		}

	}
}
