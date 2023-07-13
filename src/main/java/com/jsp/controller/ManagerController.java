package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Save = req.getParameter("Save");
		String Manager_Verification = req.getParameter("Manager_Verification");

		if (Save != null) {
			System.out.println(Save);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("SaveManager.jsp");
			requestDispatcher.forward(req, resp);

		} else if (Manager_Verification != null) {
			System.out.println(Manager_Verification);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager_Verification.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
