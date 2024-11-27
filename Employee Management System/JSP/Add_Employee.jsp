<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action = "addEmp" method = "post">
	<%
		Random rand = new Random();
		int id = rand.nextInt(10000);
		String Eid = "Employee Id:"+id;
	%>
	<%= Eid %>
	<input type="hidden" name="eid" value="<%= id %>">
	<br>
	<br>
	<label for = "name">Employee Name:</label>
	<input type = "text" name = "name" id = "name" placeholder = "Enter employee name" required>
	<br>
	<br>
	<label for = "join">Join Date:</label>
	<input type = "date" name = "join" id = "join" placeholder = "Enter employee join date" required>
	<br>
	<br>
	<label for = "salary">Employee salary:</label>
	<input type = "text" name = "salary" id = "salary" placeholder = "Enter employee salary" required>
	<br>
	<br>
	<label for = "email">Employee email:</label>
	<input type = "email" name = "email" id = "email" placeholder = "ex. abc@gmail.com" required>
	<br>
	<br>
	<label for = "phone">Employee phone number:</label>
	<input type = "text" name = "phone" id = "phone" maxLength = "10" placeholder = "Enter employee phone number" required>
	<br>
	<br>
	<input type = "submit" value = "Add Employee">
	<%String message = (String)request.getAttribute("message"); %>
	</form>
	<script>
	<% if (message != null) { %>
    alert("<%= message %>");
<% } %>
	</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>