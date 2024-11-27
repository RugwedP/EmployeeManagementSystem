package com.EmployeeManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/removeselected")
public class removeSelectedEmp extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		RequestDispatcher rd;
		PrintWriter out = res.getWriter();
		String eid = (String)req.getParameter("id");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","1234567");
			Statement st = conn.createStatement();
			String query = "DELETE FROM employee WHERE id = "+eid;
			int count = st.executeUpdate(query);
			if(count>0)
			{
				 rd = req.getRequestDispatcher("RemoveEmployee.jsp");
				 req.setAttribute("message2", "Employee remove successfully!!");
				 rd.forward(req, res);
				
			}
			else
			{
				out.println("Employee not deleted!! ");
			}
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
