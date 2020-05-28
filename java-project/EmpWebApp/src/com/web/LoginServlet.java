package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAO;
import com.dto.Employee;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginId   = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginId);		
		
		out.println("<html>");
		System.out.println("in login servlet");
		
		if(loginId.equals("hr") && password.equals("hr")){
			RequestDispatcher rd = request.getRequestDispatcher("Options.html");
			rd.forward(request, response);
			
		}
		else{		
			
			Employee emp = new Employee();
			EmployeeDAO empDAO = new EmployeeDAO();
			
			emp = empDAO.getEmployee(loginId, password);
			
			if(emp == null){
				
				out.println("<body bgcolor=yellow text=red><h1><center>Invalid Credentials</center></h1></body>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				
			}
			else{
				session.setAttribute("emp", emp);
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeHomepage");
				rd.forward(request, response);
				
			}			
		}
		
		out.println("</html>");
		out.close();		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	}