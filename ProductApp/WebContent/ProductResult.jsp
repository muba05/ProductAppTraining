<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Details</title>
</head>
<body>
	<br />
	<br />
	<form method="post" action="Product">
	<p><input type="submit" value="Create New" />
	</p> 
	</form>
	<br />
	<table border="2" bordercolor="red" align="center">
	<tr>
	<th>Product Id </th>
	<th>Product Name </th>
	<th>Product Description </th>
	<th>Start Date </th>
	<th>End Date </th>
	<th>Quantity </th>
	</tr>
	<c:forEach items="${productslist}" var = "product"  >
		<tr>
		<td>${product.prodId}</td>
		<td>${product.prodName}</td>
		<td>${product.prodDescp}</td>
		<td>${product.startDate}</td>
		<td>${product.endDate}</td>
		<td>${product.qty}</td>
		</tr>
		
	</c:forEach>
	</table>
</body>
</html>