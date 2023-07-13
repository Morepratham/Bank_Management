package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.BankCustomer;
import com.jsp.dto.Pan;
import com.jsp.service.BankCustomerService;

@WebServlet("/SaveCustomer")
public class SaveCustomer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankCustomerService personService = new BankCustomerService();
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String Pan_number = req.getParameter("Pan");

		BankCustomer person = new BankCustomer();
		person.setCust_name(name);
		person.setCust_password(password);
		person.setCust_email(email);
		person.setCust_gender(gender);
		Pan pan = new Pan();
		pan.setPan_number(Pan_number);
		pan.setBankCustomer(person);
		person.setPan(pan);
		BankCustomer person2 = personService.savePersonDetails(person);
		System.out.println(name);
		System.out.println(email);
		System.out.println(gender);
		System.out.println(password);
		List<BankCustomer> persons = new ArrayList<>();
		persons.add(person2);
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("c_name", name);
		//
//		if(pan!=null) {
//			
//			PrintWriter printWriter= resp.getWriter();
//			printWriter.write("<html><body><h1>"+"Waiting for Verification By Manager "+"</h1></body></html>");
////			printWriter.write("<br><br>");
////			printWriter.write("<html><body><h1>"+"Name of Manager is :  "+"name"+"</h1></body></html>");
//			printWriter.write("<br><br>");
//			printWriter.write("<a href='BankController.jsp'>Main Menu</a>");
//			printWriter.write("<br><br>");
//			printWriter.write("<a href='ManagerController.jsp'>Back</a>");
//		}
		if (person2 != null) {
			System.out.println("================================================");
			System.out.println(person2.getCust_name() + " " + person2.getCust_email() + " " + person2.getCust_id());
			System.out.println("============================");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "You Details are Saved : " + name + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "Your Id is : " + person2.getCust_id() + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write(
					"<html><body><h1>" + "Your Password is : " + person2.getCust_password() + "</h1></body></html>");
			printWriter.write("<br><br>");
			printWriter.write("<html><body><h1>" + "Waiting for Verification By Manager " + "</h1></body></html>");

			printWriter.write("<br><br>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='CustomerController.jsp'>Customer menu</a>");
			printWriter.write("<br><br>");
			printWriter.write("<a href='ManagerController.jsp'>Manager Menu</a>");
//			RequestDispatcher requestDispatcher=req.getRequestDispatcher("CustomerController.jsp");
//			requestDispatcher.forward(req, resp);
		} else {
			PrintWriter printWriter = resp.getWriter();
			System.out.println("============================");
			System.out.println("Bank not saved");
			System.out.println("============================");
			printWriter.write("<html><body><h1>" + "Wrong Input " + "</h1></body></html>");
			printWriter.write("<a href='CustomerController.jsp'>Customer menu</a>");
		}
	}
}
