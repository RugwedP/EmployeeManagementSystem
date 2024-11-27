package com.EmployeeManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/showemp")
public class showEmployee extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		 res.setContentType("text/html");
	        PrintWriter out = res.getWriter();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "1234567");
	            Statement st = conn.createStatement();

	            String searchEid = req.getParameter("search");

	            if(searchEid != null && !searchEid.isEmpty()) {
	                String query = "SELECT * FROM employee WHERE id = "+searchEid;
	                ResultSet rs = st.executeQuery(query);
	                out.println("<html><body><h2>Employees List</h2>");
	              
	                out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Join Date</th><th>Salary</th><th>Email</th><th>Phone</th></tr>");

	                while (rs.next()) {
	                    out.println("<tr>");
	                    out.println("<td>" + rs.getString("id") + "</td>");
	                    out.println("<td>" + rs.getString("name") + "</td>");
	                    out.println("<td>" + rs.getString("joindate") + "</td>");
	                    out.println("<td>" + rs.getString("salary") + "</td>");
	                    out.println("<td>" + rs.getString("email") + "</td>");
	                    out.println("<td>" + rs.getString("phone") + "</td>");
	                    out.println("</tr>");
	                }
	                out.println("<form><input type='button' value='Back' onclick='history.back()'></form>");

	                out.println("</table></body></html>");
	            } else {
	                out.println("<html><body><h2>Employees List</h2>");
	                out.println("<form action = 'showemp' method = 'post'>");
	                out.println("<label for = 'search'>Search By Id:</label>");
	                out.println("<input type = 'text' id = 'search' name = 'search'>");
	                out.println("<input type = 'submit' value = 'Search'>");
	                out.println("<input type='button' value='Back' onclick='window.location.href=\"Admin_page.jsp\";'>");
	                out.println("</form>");
	                out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Join Date</th><th>Salary</th><th>Email</th><th>Phone</th></tr>");
	                ResultSet rs2 = st.executeQuery("SELECT * FROM employee");

	                while (rs2.next()) {
	                    out.println("<tr>");
	                    out.println("<td>" + rs2.getString("id") + "</td>");
	                    out.println("<td>" + rs2.getString("name") + "</td>");
	                    out.println("<td>" + rs2.getString("joindate") + "</td>");
	                    out.println("<td>" + rs2.getString("salary") + "</td>");
	                    out.println("<td>" + rs2.getString("email") + "</td>");
	                    out.println("<td>" + rs2.getString("phone") + "</td>");
	                    out.println("</tr>");
	                }

	                out.println("</table></body></html>");
	            }

	            conn.close();

	        } catch (Exception e) {
	            out.println(e);
	        }
	    }
	}
			

