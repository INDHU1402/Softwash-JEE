package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.Employee;

@WebServlet("/EmployeeHomepage")
public class EmployeeHomePage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<body bgcolor=yellow text=red><center>");
		
		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute("emp");
		session.setAttribute("emp", emp);
		
		out.println("<b> Hi " +emp.getEmpName()+ "</b><br>");
		out.println("<b>Welcome to EmpHomepage</b><br>");
		out.println("<b><a href='Profile'>Profile</a></b>");
		
		
		out.println("</center></body>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}