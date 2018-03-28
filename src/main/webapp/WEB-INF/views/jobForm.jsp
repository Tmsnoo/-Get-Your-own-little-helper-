<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="jspf/head_config.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add job</title>
</head>
<body>
<form:form method="POST" modelAttribute="job">
		<div>
			<label>Title
			<form:input path="title" /></label>
			<form:errors path="title">Title must have at least 3 chars (no more than 20)</form:errors>
		</div>
		<div>
		<form:textarea path="description"  rows="5" cols="50" placeholder="description"></form:textarea>
			<form:errors path="description">Max 200 chars</form:errors>
		</div>
		<div>
			<form:label path="telNo"  >Contact telephone number</form:label>
			<form:input type="number" path="telNo" placeholder="telephone number"/>
			<form:errors path="telNo">Insert valid telephone number</form:errors>
		</div>
		<div>
			<form:label path="rateHour"  >Rate per hour(PLN)</form:label>
			<form:input type="number" path="rateHour" placeholder="rateHour (PLN)"/>PLN/h
		</div>
		<div>
			<form:label path="city"  >City</form:label>
			<form:input path="city" placeholder="City"/>
		</div>
		<div>
			<form:label path="voivodeship"  >Voivodeship</form:label>
			<form:input path="voivodeship" placeholder="voivodeship"/>
		</div>
		<div>
			<form:checkboxes path="categories"  items="${categoriesList}" 
			 itemLabel="name" itemValue="id" />
		</div>
		<div>
		<form:errors path="*"  />
		<input type="submit"/>
		</div>
	</form:form>
</body>
</html>