<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.employee.dao.EmployeeDao,java.sql.ResultSet" %>
	
	<%EmployeeDao ed = new EmployeeDao();
	 	ResultSet rs = ed.stateslist();
		while(rs.next()){%>
	<option value="<%=rs.getString("statenames") %>"><%=rs.getString("statenames")%> </option>
	<%} %>


	

