package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.BankManager;
import com.jsp.service.BankManagerService;

@WebServlet("/Manager_Verification")
public class Manager_Verification extends HttpServlet {
	BankManagerService managerService = new BankManagerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		int id1 = Integer.parseInt(id);

		BankManager manager = managerService.getManagerById(id1);
		if (manager.getManager_passwaord().equals(password)) {
//			creating cookie
			Cookie cookie = new Cookie("managerid", id);

			resp.addCookie(cookie);

			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + " Verification is Successfull" + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='Verified_Manager.jsp'> Click here to proceed</a>");
			printWriter.write("<br><br>");
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + " Verification is UnSuccessfull" + "  " + id1 + "  " + password
					+ "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='Verified_Manager.jsp'> Click here to proceed</a>");
			printWriter.write("<br><br>");
		}
	}
}
