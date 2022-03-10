<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Relationship Management</title>
<style type="text/css">
h2 {
	text-align: center;
}
 h3 {
	text-align: center;
	font-style: italic;
	color: red;
}
.myTable {
	width: 500px;
	margin: 50px auto;
	font-size: 20px;
	background-color: #eee;
	border-collapse: collapse;
	box-shadow: 0 0 10px black;
}

.myTable th {
	background-color: #000;
	color: white;
	width: 50%;
}

.myTable td, .myTable th {
	padding: 5px;
	border: 1px solid #000;
}

tr{
	  height:45px;
	}
	td, th{
	  border:1px solid black;
	  text-align:left
	}
	
</style>
</head>
<body>

	<div class="container"
		style="margin: 50px; background-color: hsla(120, 100%, 25%, 0.3)">

		<p>
			<a href="http://localhost:8080/SpringMvcORM/"><strong>Home</strong></a>
		</p>
		<h2>
			<strong>Customer Relationship Management - Spring mvc orm</strong>
		</h2>

		<br> <br> <br> <a
			href="http://localhost:8080/SpringMvcORM/addPage"><button>Add
				Customer</button></a>
		<table class="myTable" border="1">
			<caption><strong></strong>Customer Details</strong></caption>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="customer" items="${customers}">
				<tbody>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a
							href="http://localhost:8080/SpringMvcORM/updatePage/${customer.id}"><button>Update</button></a> <a
							href="http://localhost:8080/SpringMvcORM/deleteCustomer/${customer.id}"><button>Delete</button></a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<h3>
			<strong>${message}</strong>
		</h3>
	</div>
</body>
</html>