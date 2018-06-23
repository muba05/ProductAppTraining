<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<form method="get" action="Register" style="align-content: center">
		<br />
		<br />
		<br />
		<table align="center" border="2" bordercolor="red">
		<tr><td>User Name : <input type="text" name="username" /></td><tr>
		<tr><td>Password  : <input type="password" name="userpassword" /></td></tr>
		<c:if test="${password == 'password'}">
			<p style="color: red">Password Mismatch !!!!</p>
		</c:if>
		<tr><td><input type="submit" value="Login"/></td></tr>
		</table>  
	</form>
	
</body>
</html>