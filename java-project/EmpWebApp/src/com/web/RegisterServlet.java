package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.dao.EmployeeDAO;
import com.dto.Employee;

@WebServlet("RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		Employee emp = new Employee();
		EmployeeDAO empDAO = new EmployeeDAO();
		
		emp.setEmpId(Integer.parseInt(request.getParameter("empId")));
		emp.setEmpName(request.getParameter("empName"));
		emp.setSalary(Double.parseDouble(request.getParameter("salary")));
		emp.setLoginId(request.getParameter("LoginId"));
		emp.setPassword(request.getParameter("password"));
		
		int r = empDAO.setEmployee(emp);
		if(r == 0){
			out.println("<body bgcolor=yellow text=red><h1><center>Registration Failed!</center></h1></body>");
			RequestDispatcher rd = request.getRequestDispatcher("Register.html");
			rd.include(request, response);			
		}
		else{
			out.println("<body bgcolor=yellow text=blue><h1><center>Registration Successful!!</center></h1></body>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);			
		}
		
		out.println("</html>");
		out.close();
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}}
