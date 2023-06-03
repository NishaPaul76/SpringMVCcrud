<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="com.techpalle.model.Student" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Page</title>
</head>
<body>


<h1>Students List:</h1>

<table border="1">

	<thead>
	<tr>
		<th>Sno</th>
		<th>Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Mobile</th>
		<th>Actions</th>
	</tr>
	</thead>
	
	<tbody>
	<%ArrayList<Student> s = (ArrayList<Student>) request.getAttribute("student");%>
		<% 
			for (Student item:s)
			{
				%>
			
			<tr>
				<td><c:out value="<%= item.getSno() %>"></c:out></td>
				<td><c:out value="<%= item.getName() %>"></c:out></td>
				<td><c:out value="<%= item.getEmail() %>"></c:out></td>
				<td><c:out value="<%= item.getPassword() %>"></c:out></td>
				<td><c:out value="<%= item.getMobile() %>"></c:out></td>
				<td>
					<a href="#"> Edit</a>
					<a href="#">Delete</a>
				</td>
			</tr>
			
			
			<% 
			}
			%>
		
	
	
	</tbody>
</table>


</body>
</html>