<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To Register</h1>
	
	<form action="insert" method ="post">
	Name:<input type="text" name="tbName"/>
	<br>
	
	Email:<input type="email" name="tbEmail"/>
	<br>
	
	password : <input type="password" name="tbPass"/>
	<br>
	
	Mobile <input type="tel" name="tbMobile"/>
	<br>
	
	<input type="submit" value="Save"/>
	
	</form>
</body>
</html>