<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="jspf/head_config.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Ukrainian</title>
</head>
<body>
<%@ include file="jspf/header.jspf" %>
<form:form method="POST"  modelAttribute="ukraina">
		<div>
			<label>First Name
			<form:input path="firstName" /></label>
			<form:errors path="firstName">Please insert Your name</form:errors>
		</div>
		<br>
		<div>
			<label>Last Name
			<form:input path="lastName" /></label>
			<form:errors path="lastName">Please insert Your last name</form:errors>
		</div>
		<br>
		<div>
			<form:label path="city"  >City</form:label>
			<form:input path="city" placeholder="City"/>
		</div>
		<br>
		<div>
			<form:label path="voivodeship"  >Voivodeship</form:label>
			<form:input path="voivodeship" placeholder="voivodeship"/>
		</div>
		<br>
		<div>
			Male: <form:radiobutton path="sex" value="M"/>
			Female: <form:radiobutton path="sex" value="F"/>
		</div>
		<br>
		<div>
		<form:textarea path="description"  rows="5" cols="50" placeholder="description"></form:textarea>
			<form:errors path="description">Max 200 chars</form:errors>
		</div>
		<div>
		<form:errors path="*"  />
		<input type="submit"/>
		</div>
	</form:form>
	<%@ include file="jspf/footer.jspf" %>
</body>
</html>
