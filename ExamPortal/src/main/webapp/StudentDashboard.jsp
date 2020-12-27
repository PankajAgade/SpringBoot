<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Student DashBoard</h1>
		<br><br>
		<br><br><br><br>
		
		
		<br><br>
		
		<table border="1">
			<thead>
				<tr>
					<th>Test Name</th>
					<th>Score / Attempt</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="combo" items="${trlist}">
					<tr>
						<td>${combo.name}</td>
						<td>
						<c:choose>
							<c:when test="${combo.attempted}">${combo.marks} <button><a href="http://localhost:8080/review${combo.testid}">/ Review</a></button></c:when>
							<c:otherwise><button><a href="http://localhost:8080/attempt${combo.testid}">Attempt</a></button></c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br><br><br><br>
		
		<br><br>
		<button><a href="http://localhost:8080/logout">Logout</a></button>
	</div>
</body>
</html>