<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome admin</h1>
	<form action="Add_Employee.jsp" method = "post">
		<input type = "submit" value = "Add Employee">
	</form>
	<br>
	<br>
	<form action="showemp" method = "post">
		<input type = "submit" value = "Show Employee">
	</form>
	<br>
	<br>
	<form action="RemoveEmployee.jsp" method = "post">
		<input type = "submit" value = "Remove Employee">
	</form>
	<br>
	<br>
	<form action="UpadateEmployee.jsp" method = "post">
		<input type = "submit" value = "Update Employee">
	</form>
</body>
</html>