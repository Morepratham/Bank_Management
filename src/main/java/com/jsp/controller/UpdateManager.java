package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.BankManager;
import com.jsp.service.BankManagerService;

@WebServlet("/UpdateManager")
public class UpdateManager extends HttpServlet {
	BankManagerService managerService = new BankManagerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		BankManager manager = managerService.getManagerById(id1);

		manager.setManager_name(name);
		manager.setManager_email(email);
		BankManager manager2 = managerService.updateManager(id1, manager);

		if (manager2 != null) {
			System.out.println("================================================");
			System.out.println(manager2.getManager_name() + " " + manager2.getManager_email());
			System.out.println("============================");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Details of Manager are Updated " + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<html><body><h1>" + "Name of Manager is :  " + "name" + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='BankController.jsp'>Main Menu</a>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='ManagerController.jsp'>Back</a>");
//		RequestDispatcher requestDispatcher=req.getRequestDispatcher("ManagerController.jsp");
//		requestDispatcher.forward(req, resp);
		} else {
			System.out.println("============================");
			System.out.println("Invalid Id");
			System.out.println("============================");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "Details of Manager are Not Updated " + "</h1></body></html>");
			printWriter.write("<br><br>");
//		printWriter.write("<html><body><h1>"+"Name of Manager is :  "+"name"+"</h1></body></html>");
//		printWriter.write("<br><br>");
			printWriter.write("<a href='BankController.jsp'>Main Menu</a>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='ManagerController.jsp'>Back</a>");
//		RequestDispatcher requestDispatcher=req.getRequestDispatcher("ManagerController.jsp");
//		requestDispatcher.forward(req, resp);
		}
	}
}
