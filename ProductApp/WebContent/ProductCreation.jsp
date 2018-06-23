<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<br />
	<br />
	<form method="get" action="Product">
		<input type="submit" value="Fetch All products" />
	</form>
	<br />
	<form method="post" action="Product">
		<table align="center" border="2" bordercolor="gray">
		<tr>
		<td>Product Id <td>
		<td><input type="text" name="prodId" /></td>
		</tr>
		<tr>
		<td>Product Name <td>
		<td><input type="text" name="prodName" /></td>
		</tr>
		<tr>
		<td>Product Description  <td>
		<td><input type="text" name="prodDescp" /></td>
		</tr>
		<tr>
		<td>Product StartDate  <td>
		<td><input type="date" name="startDate" /></td>
		</tr>
		<tr>
		<td>Product EndDate <td>
		<td><input type="date" name="endDate" /></td>
		</tr>
		<tr>
		<td>Quantity <td>
		<td><input type="text" name="qty" /></td>
		</tr>
		<tr>
		<td><input type="submit" value="Add" /></td>
		</tr>
		
		</table>
	</form>	
	
	

</body>
</html>