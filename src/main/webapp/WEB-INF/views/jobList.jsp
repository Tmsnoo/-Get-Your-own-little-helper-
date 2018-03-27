<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="jspf/head_config.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
   <c:forEach items="${jobList}" var="job" >
    <tr id="${job.id}">
    	<td><b>Job Title</b></td>
        <td>${job.title}</td>
        <td><b>Job Description</b></td>
        <td>${job.description}</td>
        <td><b>Rate hours(PLN/h)</b></td>
        <td>${job.rateHour}</td>
        <td><b>City</b></td>
        <td>${job.city}</td>
        <td><b>Voivodeship</b></td>
        <td>${job.voivodeship}</td>
        <td><b>Added</b></td>
        <td>${job.created}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>