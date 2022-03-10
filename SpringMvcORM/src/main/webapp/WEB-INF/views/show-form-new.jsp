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
	<div 
		style="margin: 50px; background-color: hsla(120, 100%, 25%, 0.3)">
		<p>
			<a href="http://localhost:8080/SpringMvcORM/"><strong>Home</strong></a>
		</p>
		<h2>
			<strong>Save Customer</strong>
		</h2>
		<form:form cssClass="formcss"
			action="http://localhost:8080/SpringMvcORM/addCustomer"
			modelAttribute="customer">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<br>
			<br>
<strong>First Name 	:</strong> <form:input path="firstName" value="" />
			<form:errors path="firstName" cssClass="error" />
			<br>
			<br>
<strong>Last  Name 	:</strong> <form:input path="lastName" value="" />
			<form:errors path="lastName" cssClass="error" />
			<br>
			<br>
<strong>Email		:</strong> <form:input path="email" value="" />
			<form:errors path="email" cssClass="error" />
			<br>
			<br>
			<input type="submit" value="Add Customer" />
		</form:form>
				<h3>
			<strong>${message}</strong>
		</h3>
	</div>

</body>
</html>