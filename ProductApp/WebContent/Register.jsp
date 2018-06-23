<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<form method="post" action="Register">
		<br />
		<br />
		<br />
		<c:if test="${DepError == 'admin'}">
			<p style="color:red">Department code does not match</p>
		</c:if>
		<c:if test="${DateError == 'date'}">
			<p style="color:red">Date of Joining cannot be less than today date</p>
		</c:if>
		
		<input type="hidden" value="Admin" name="admin" />
		<table border="1" bordercolor="blue" align="center">
		<tr>
		<td>Emp Id : </td>
		<td><input type="text" name="empId" /></td>
		</tr>
		<tr>
		<td>Emp Name : </td>
		<td><input type="text" name="empName" /></td>
		</tr>
		<tr>
		<td>Department code : </td>
		<td><input type="text" name="depCode" /></td>
		</tr>
		<tr>
		<td>DOJ : </td>
		<td><input type="date" name="doj" /></td>
		</tr>
		<tr>
		<td>Password : </td>
		<td><input type="password" name="password" /></td>
		</tr>
		<tr>
		<td><input type="submit" value="Add" /></td>
		</tr>
		
		</table>
	
	</form>
	
	<br />
	<br />
	
	<form method="get" action="Register">
		<table border="1" bordercolor="red" align="center">
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>	
		</table>	
	</form>	
	
</body>
</html>