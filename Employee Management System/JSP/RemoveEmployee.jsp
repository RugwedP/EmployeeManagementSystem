<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String message =(String) request.getAttribute("message"); %>
<%String message2 =(String) request.getAttribute("message2"); %>
	<h1>remove employee</h1>
	<form action="removeEmp" method = "post">
	<label for = "search">Search By Id:</label>
	<input type = "text" id = "eid" name = "eid">
	<input type = "submit" value = "search">
	<input type = "button" value = "Back" onclick =window.location.href="Admin_page.jsp">
	</form>
	 <script>
    
	 
	 
    <% if (message != null) { %>
    alert("<%= message %>");
<% } %>

<% if (message2 != null) { %>
alert("<%= message2 %>");
<% } %>
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>