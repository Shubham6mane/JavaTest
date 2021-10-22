package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Employee;
import com.mysql.connection.MySqlConnection;

public class EmployeeDao {
	MySqlConnection  msc = new MySqlConnection();
	Connection con = msc.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean validate(Employee emp) {
		boolean status = false;
		try {
			ps= con.prepareStatement("select * from employee where username=? and password=?");
			ps.setString(1,emp.getUsername());
			ps.setString(2,emp.getPassword());
			rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public int register(Employee emp) {
		int status = 0;
		try {
			ps = con.prepareStatement("insert into employee (firstname, lastname, gender, country, state, username, password) values (?,?,?,?,?,?,?)");
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getGender());
			ps.setString(4, emp.getCountry());
			ps.setString(5, emp.getState());
			ps.setString(6, emp.getUsername());
			ps.setString(7, emp.getPassword());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return status;
	}
	
	public ResultSet stateslist() {
		ResultSet rs = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from states");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
