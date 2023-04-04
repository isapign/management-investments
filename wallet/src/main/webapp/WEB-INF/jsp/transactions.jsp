<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions List</title>
</head>
<body>
	<h1>Transactions List</h1>
	<table>
		<thead>
			<tr>
				<th>TICKER</th>
				<th>DATE</th>
				<th>PRICE</th>
				<th>QUANTITY</th>
				<th>TYPE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transactions}" var="t">
				<tr>
					<td>${t.ticker}</td>
					<td>${t.date}</td>
					<td>${t.price}</td>
					<td>${t.quantity}</td>
					<td>${t.type}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
