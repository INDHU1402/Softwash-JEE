package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dto.Employee;

@WebServlet("/DisplayAllServlet")
public class DisplayAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		System.out.println("in display all servlet");	
		
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		
		
		empList = empDAO.displayAllEmployee();
		
		
		if(empList == null){
			out.println("<body bgcolor=yellow text=red><h1><center>No results found!</center></h1></body>");
			RequestDispatcher rd = request.getRequestDispatcher("HrHomePage");
			rd.include(request, response);
		}
		
		else{
			System.out.println(" results found");
			out.println("<body bgcolor=yellow text=blue>");
			out.println("<center");
			out.println("<table border=5>");
			
			out.println("<tr>");
			out.println("<th>EmpId</th>");
			out.println("<th>EmpName</th>");
			out.println("<th>salary</th>");
			out.println("<th>UserId</th>");
			out.println("</tr>");
			out.println("<br>");
			
			for(Employee emp : empList){
				
					out.println("<tr>");
					out.println("<td>" + emp.getEmpId() + " </td>");
					out.println("<td>" + emp.getEmpName() + " </td>");
					out.println("<td>" + emp.getSalary() + "</td>");
					out.println("<td>" + emp.getLoginId() + "</td>");
					out.println("</tr>");
					out.println("<br>");
					
			}
			out.println("</table></center></body>");
			RequestDispatcher rd = request.getRequestDispatcher("HrHomepage");
			rd.include(request, response);
					
			
		}
		
		out.println("</html>");
		out.close();
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}