<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Profile</title>
<%@ include file="jspf/head_config.jspf"%>
<script src="${pageContext.request.contextPath }/resources/js/test.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/tel.js"></script>
</head>
<body>
	<div class="pos-f-t">
		<div class="collapse" id="navbarToggleExternalContent">
			<div class="bg-dark p-4">
				<h3 class="text-white">Select</h3>
				Telephone<input type="checkbox" id="checkbox1" />
				<span class="text-muted">Choose voivodeship<c:forEach
						items="${voivodeshipList}" var="voivode">
						<li>${voivode}<input type="checkbox" id="${voivode}" /></li>
					</c:forEach>
				</span>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarToggleExternalContent"
		aria-controls="navbarToggleExternalContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<h2 class="text-white">Search Settings</h2></nav>
	</div>
	Welcome : ${Ukraina.firstName} ${Ukraina.lastName }

	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">Job Title</th>
				<th scope="col">Job Description</th>
				<th scope="col">Hour rate(PLN/h)</th>
				<th scope="col">City</th>
				<th scope="col">Voivodeship</th>
				<th scope="col">Added</th>
				<th scope="col" class="tel">Telephone</th>
				<th scope="col">Categories</th>
			</tr>
		</thead>
		<c:forEach items="${jobList}" var="job">
			<span class="${job.voivodeship }" id="${job.id}">
				<tbody>
					<tr>
						<td>${job.title}</td>
						<td>${job.description}</td>
						<td>${job.rateHour}</td>
						<td>${job.city}</td>
						<td>${job.voivodeship}</td>
						<td>${job.created}</td>
						<td class="tel">${job.telNo}</td>
						<c:if test="${job.categories ne null}">
							<c:forEach items="${job.categories}" var="category">
								<td><c:out value="${category.name}" /></td>
							</c:forEach>
						</c:if>
					</tr>
				</tbody>
			</span>
		</c:forEach>
	</table>
	<%@ include file="jspf/footer.jspf"%>
</body>
</html>