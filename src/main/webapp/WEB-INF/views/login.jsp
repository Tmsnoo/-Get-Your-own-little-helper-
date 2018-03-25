<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
<head>

<%@ include file="jspf/head_config.jspf"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>LOGIN</title>
</head>
<body>
	<%@ include file="jspf/header.jspf"%>
	<%@ include file="jspf/main_menu.jspf"%>

	<form:form method="POST" modelAttribute="user">
		<div class="container">
		<span class="input-group-text" id="">Email 
			<form:label path="email" />
			<form:input type="email" path="email" />
			<form:errors path="email">Email address is not valid</form:errors></span>
		</div>
		<div class="container">
		<span class="input-group-text" id="">Password 
			<form:password path="password" />
			<form:errors path="password">Password must have at least 8 chars</form:errors></span>
		</div>
		<div class="container">
			<input type="submit" value="Log In"/>
		</div>
	</form:form>


	<%@ include file="jspf/footer.jspf"%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>