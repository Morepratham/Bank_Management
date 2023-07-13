package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Verified_Manager")
public class Verfied_Manager extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Update = req.getParameter("Update");
		String GetAll = req.getParameter("GetAllCustomer");
		if (Update != null) {
			System.out.println(Update);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateManager.jsp");
			requestDispatcher.forward(req, resp);
		} else if (GetAll != null) {
			System.out.println(Update);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("GetAllCustomer.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
