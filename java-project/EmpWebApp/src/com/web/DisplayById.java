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

@WebServlet("/DisplayById")
public class DisplayById extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		System.out.println("in display by id servlet");		

		Employee emp = new Employee();
		EmployeeDAO empDAO = new EmployeeDAO();
		emp = empDAO.getEmployee(empId);
		
		System.out.println(emp);
		System.out.println("!!!");	
		
			
		if(emp == null){
			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage");
			rd.include(request, response);
			System.out.println("no results found");
			out.println("<body bgcolor=yellow text=red><h1><center>No results found!!!</center></h1></body>");
		}
		
		else{
		
			request.setAttribute("emp", emp);
			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage");
			rd.include(request, response);
			
			
						
		}
		
		out.println("</html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}