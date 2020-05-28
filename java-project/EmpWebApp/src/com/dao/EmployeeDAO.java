package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.dto.Employee;

public class EmployeeDAO {
	public Employee getEmployee(String loginId, String password) {

		System.out.println("in dao class");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Employee emp = new Employee();
		con = DBConnection.getConnection();

		String SELECT = "Select * from employee where loginId = ? and password = ? ";
		

		try {
			pst = con.prepareStatement(SELECT);			
			pst.setString(1, loginId);
			pst.setString(2, password);
			rs = pst.executeQuery();

			if(rs.next()) {
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setLoginId(rs.getString(4));
				emp.setPassword(rs.getString(5));
				System.out.println("Emp found!");

				return emp;
			}

		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int setEmployee(Employee emp){
		
		Connection con = null;
		PreparedStatement pst = null;
		con = DBConnection.getConnection();
		
		String INSERT = "insert into employee values(?, ?, ?, ?, ?)";
		
		try{
			pst = con.prepareStatement(INSERT);	
			pst.setInt(1, emp.getEmpId());
			pst.setString(2,emp.getEmpName());
			pst.setDouble(3, emp.getSalary());
			pst.setString(4, emp.getLoginId());
			pst.setString(5, emp.getPassword());
			int result = pst.executeUpdate();
			return result;
			
			
		}catch (SQLException e) {			
			e.printStackTrace();
		}
		return 0;
		
		
		
	}
	
	public List<Employee> displayAllEmployee(){
		
		Connection con = null;
		PreparedStatement pst = null;
		con = DBConnection.getConnection();
		ResultSet rs = null;
		List<Employee> empList = new ArrayList<Employee>();
		
		
		String SELECT = "select * from employee";
		
		try {
			
			pst = con.prepareStatement(SELECT);
			rs = pst.executeQuery();
			
			while(rs.next()){	
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setLoginId(rs.getString(4));
				empList.add(emp);
			}
			
			return empList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}

	public Employee getEmployee(int empId) {
		System.out.println("in dao class");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		Employee emp = new Employee();
		con = DBConnection.getConnection();

		String SELECT = "Select * from employee where empId=?";
		

		try {
			pst = con.prepareStatement(SELECT);			
			pst.setInt(1, empId);
			rs = pst.executeQuery();
			System.out.println("query executed!");

			if(rs.next()) {
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setLoginId(rs.getString(4));
				
				System.out.println("Emp found!");

				return emp;
			}

		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}