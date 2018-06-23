<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Console</title>
</head>
<body>
	
	<br /><br /><br />
	<table border="2" align="center" bordercolor="green">
	<tr>
	<td>
	<form method="post" action="Product">
		<input type="submit" value="Add Product" style="background-color: yellow;" />
	</form>
	</td>
	</tr>
	<tr>
	<td>
	<form method="get" action="Product">
		<input type="submit" value="Fetch All Products" style="background-color: yellow" />
	</form>
	</td>
	</tr>
	</table>
	
</body>
</html>