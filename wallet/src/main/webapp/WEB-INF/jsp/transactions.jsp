<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Transactions List</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="container">
	<form action="<c:url value="/transactions"/>" method="POST">
		<div class="form-group">
			<label for="ticker">Ticker</label>
			<input id="ticker" name="ticker" class="form-control">
		</div>
		<div class="form-group">
			<label for="date">Date</label>
			<input id="date" name="date" class="form-control">
		</div>
		<div class="form-group">
			<label for="price">Price</label>
			<input id="price" name="price" class="form-control">
		</div>
		<div class="form-group">
			<label for="quantity">Quantity</label>
			<input id="quantity" name="quantity" class="form-control">
		</div>
		<div class="form-group">
			<label for="type">Type</label>
			<input id="type" name="type" class="form-control">
		</div>
		<input type="submit" value="Save" class="mt-2 btn-primary">
	</form>

	<h1 class="text-center">Transactions List</h1>
	<table class="table table-hover table-striped table-bordered">
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
