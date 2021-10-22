package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.employee.dao.EmployeeDao;


@WebServlet("/LoginOrRegisterServlet")
public class LoginOrRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String controller = request.getParameter("controller");
		if(controller != null && controller.equals("login")) {
			login(request,response);
		}
		
		else if(controller != null && controller.equals("register")) {
			registration(request,response);
		}
		
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Employee emp = new Employee();
		emp.setUsername(username);
		emp.setPassword(password);
		EmployeeDao ed = new EmployeeDao();
		if(ed.validate(emp))
			out.println("Welcome to home page");
		else
			out.println("Login failed");
			
	}
	
	public void registration(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Employee emp = new Employee();
		emp.setFirstName(firstname);
		emp.setLastName(lastname);
		emp.setGender(gender);
		emp.setCountry(country);
		emp.setState(state);
		emp.setUsername(username);
		emp.setPassword(password);
		EmployeeDao ed = new EmployeeDao();
		int status = ed.register(emp);
		if(status > 0)
			out.println("Registration successfull");
		else
			out.println("Registration failed");
		
	}

}
