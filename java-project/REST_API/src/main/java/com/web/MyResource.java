package com.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import com.dao.EmployeeDAO;
import com.dto.Employee;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@Path("hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Got it hello!";
    }
	@Path("hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it hi!";
    }
	@Path("getEmpById/{empId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmpById(@PathParam("empId") int empId) {
		System.out.println(empId);
		Employee emp1 = new Employee(100,"shivani",9999.99);
		Employee emp2 = new Employee(101,"shivani123",9998.99);
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		for(Employee e:empList) {
			if(e.getEmpId() == empId) {
				System.out.println("Success");
				return e;
			}
		}
		return null;
	}
	@Path("AllEmp")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void AllEmp(Employee emp) {
		EmployeeDAO empDAO = new EmployeeDAO();
		int employee = empDAO.getEmployee(emp);
		if (employee > 0) {
			System.out.println("Good");;
		}
		else {
			System.out.println("Invalid");
		}
	}}
	

	