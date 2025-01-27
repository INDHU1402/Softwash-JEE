package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DBConnection;
import com.dto.Employee;

public class EmployeeDAO {

	public Employee getEmployee(int empId,String empName,double salary,String loginId,String password) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "insert into employee values(?,?,?,?,?)";
		con = DBConnection.getConnection();

		try {
			pst = con.prepareStatement(SELECT);
			pst.setInt(1, empId);
			pst.setString(2, empName);
			pst.setDouble(3,salary);
			pst.setString(4,loginId);
			pst.setString(5,password);
			
			rs = pst.executeQuery();
			
			if(rs.next()){
				
				Employee emp = new Employee();
				
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setLoginId(rs.getString(4));
				emp.setPassword(rs.getString(5));
	
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}




		return null;
	}

	

	public Employee register(String empId, String empName, String salary, String loginId, String password) {
		
		return null;
	}

	

}