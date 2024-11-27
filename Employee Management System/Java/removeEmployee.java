package com.EmployeeManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/removeEmp")
public class removeEmployee extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		String eid = req.getParameter("eid");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","1234567");
			Statement st = conn.createStatement();
			if(eid!=null && !eid.isEmpty())
			{
				
					
				String query = "SELECT * FROM employee WHERE id = "+eid;
				ResultSet rs = st.executeQuery(query);
					 if(rs.next())
					 {
						 
						    out.println("<html><body><h2>Employee List</h2>");
			                out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Join Date</th><th>Salary</th><th>Email</th><th>Phone</th></tr>");
			                rs.close();
			                st.close();

			                // Create a new Statement and execute the query again
			                Statement st2 = conn.createStatement();
			                ResultSet rs2 = st2.executeQuery(query);

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
			                out.println("<form><input type='button' value='Back' onclick='history.back()'></form>");
			                
			               
			                
			                
			                out.println("<form action='removeselected' method='post'>");
			                out.println("<input type='hidden' name='id' value='" + eid + "'>"); // Add hidden input field to pass eid
			                out.println("<input type='submit' value='Remove'>");
			                out.println("</form>");

			                out.println("</table></body></html>");
					 }
					 else
					 {
						 RequestDispatcher rd = req.getRequestDispatcher("RemoveEmployee.jsp");
						 req.setAttribute("message", "Employee id is not present!!");
						 rd.forward(req, res);
					 }
					 
				
			}
		}catch(Exception e)
		{
			out.println(e);		}
	}
}
	

