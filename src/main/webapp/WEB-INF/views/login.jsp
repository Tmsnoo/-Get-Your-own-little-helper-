<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="jspf/head_config.jspf"%>

</head>
<body>
	<%@ include file="jspf/header.jspf"%>
	<p>   User: ${loggedUser.username}</p>
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
<div class="alert alert-warning" role="alert">
 <a href="${pageContext.request.contextPath }/user/register" class="alert-link">Register</a>
</div>

	<%@ include file="jspf/footer.jspf"%>

</body>
</html>