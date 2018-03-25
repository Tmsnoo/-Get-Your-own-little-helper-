<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
<head>
<%@ include file="jspf/head_config.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<%@ include file="jspf/header.jspf"%>
	<%@ include file="jspf/main_menu.jspf"%>
	<form:form method="POST" modelAttribute="user">
		<div>
			<label >USERNAME(Ім'я користувача)
			<form:input path="username" /></label>
		</div>
		<div>
			<form:label path="password"  >Set Password<form:password path="password" placeholder="Password" />
			<form:errors path="password">Password must have at least 8 chars</form:errors></form:label>
		</div>
		<div>
			<form:label path="email"  >Your Email Address</form:label>
			<form:input type="email" path="email" placeholder="Em@il"/>
			<form:errors path="email"></form:errors>
		</div>
		<div>
		<input type="submit"/>
		</div>
	</form:form>


	<%@ include file="jspf/footer.jspf"%>

</body>
</html>