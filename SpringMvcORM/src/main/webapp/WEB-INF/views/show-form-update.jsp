<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style>
h2 {
	text-align: center;
}

h3 {
	text-align: center;
	font-style: italic;
	color: red;
}

.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<div style="margin: 50px; background-color: hsla(120, 100%, 25%, 0.3)">
		<p>
			<a href="http://localhost:8080/SpringMvcORM/"><strong>Home</strong></a>
		</p>
		<h2>
			<strong>Save Customer</strong>
		</h2>
		<form:form
			action="http://localhost:8080/SpringMvcORM/updateCustomer"
			modelAttribute="customer">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<br>
			<br>
			<form:hidden path="id" value="${customer.id}" />
First Name 	: <form:input path="firstName" value="${customer.firstName}" />
			<br>
			<br>
Last  Name 	: <form:input path="lastName" value="${customer.lastName}" />
			<br>
			<br>
Email		: <form:input path="email" value="${customer.email}" />
			<br>
			<br>
			<input type="submit" value="Update Customer" />
		</form:form>
		<h3>
			<strong>${message}</strong>
		</h3>
	</div>

</body>
</html>