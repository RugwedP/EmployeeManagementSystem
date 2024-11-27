package com.EmployeeManagement;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/admin")
public class login extends HttpServlet{
	RequestDispatcher rd;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out = res.getWriter();
		String fixed_username = "rugwed8181";
		String fixed_pass = "rugwed@8181";
		
		String username = req.getParameter("text");
		String password = req.getParameter("password");
		
		if(fixed_username.equals(username) && fixed_pass.equals(password))
		{
			rd = req.getRequestDispatcher("Admin_page.jsp");
			rd.forward(req, res);
		}
		else
		{
			 rd = req.getRequestDispatcher("Login.jsp");
			 req.setAttribute("message", "Invalid details enter correct usename and password!!");
			 rd.forward(req, res);
		}
	}
}
