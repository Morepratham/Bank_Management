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
import com.jsp.dto.BankManager;
import com.jsp.service.BankCustomerService;
import com.jsp.service.BankManagerService;

@WebServlet("/Approve")
public class Approve extends HttpServlet {
	BankManagerService managerService = new BankManagerService();
	BankCustomerService personService = new BankCustomerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Customerid = req.getParameter("CustomerId");
		;
		String Status = req.getParameter("Status");
		int c_id = Integer.parseInt(Customerid);
		HttpSession httpSession = req.getSession();
		int managerid = (int) httpSession.getAttribute("managerid");
		BankCustomer person = personService.getPersonById(c_id);
		BankManager manager = managerService.approvePersonById(c_id, managerid);
		PrintWriter printWriter = resp.getWriter();
		printWriter.write("<html><body><h1>" + "Applicant Name : " + person.getCust_name() + "</h1></body></html>");
		printWriter.write("<html><body><h1>" + "Status Approved " + "</h1></body></html>");
		printWriter.write("<br><br>");

		printWriter.write("<a href='CustomerController.jsp'>Customer menu</a>");
		printWriter.write("<br><br>");
		printWriter.write("<a href='ManagerController.jsp'>Manager Menu</a>");
		if (manager != null) {

//			RequestDispatcher requestDispatcher= req.getRequestDispatcher("GetAllCustomer.jsp");
//			requestDispatcher.forward(req, resp);

		} else {
			System.out.println("wrong input");
		}
	}
}
