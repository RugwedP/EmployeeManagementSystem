package com.EmployeeManagement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@WebServlet("/addEmp")
public class add_Employee extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id = req.getParameter("eid");
		String name = req.getParameter("name");
		String joindate = req.getParameter("join");
		String salary = req.getParameter("salary");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","1234567");
			PreparedStatement pst = conn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?);");
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, joindate);
			pst.setString(4, salary);
			pst.setString(5, email);
			pst.setString(6, phone);
			
			
			
			int count = pst.executeUpdate();
			
			if(count>0)
			{
				req.setAttribute("message", "Data stored Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("Add_Employee.jsp");
				rd.forward(req, res);
			}
			else
			{
				req.setAttribute("message", "Data not stored Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("Add_Employee.jsp");
				rd.forward(req, res);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
}
