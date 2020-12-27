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
		<h1 align="center">Question in Test</h1>
		<br><br><br>
		
		<table border="1">
			<tr>
				<th>QID</th>
				<th>Question</th>
				<th>Option A</th>
				<th>Option B</th>
				<th>Option C</th>
				<th>Option D</th>
				<th>CorrectAns</th>
				<th>Action</th>
			</tr>
			
		<c:forEach var="question" items="${qlisttest}">
			<tr>
				<td>${question.id}</td>
				<td>${question.question}</td>
				<td>${question.opa}</td>
				<td>${question.opb}</td>
				<td>${question.opc}</td>
				<td>${question.opd}</td>
				<td>${question.answer}</td>
				<td><button><a href="http://localhost:8080/removequestion${question.id}">Remove</a></button></td>			
			</tr>
		</c:forEach>
		</table>
		
		<br><br><br>
		
		<table border="1">
			<tr>
				<th>QID</th>
				<th>Question</th>
				<th>Option A</th>
				<th>Option B</th>
				<th>Option C</th>
				<th>Option D</th>
				<th>CorrectAns</th>
				<th>Action</th>
			</tr>
			
		<c:forEach var="question" items="${qlistdb}">
			<tr>
				<td>${question.id}</td>
				<td>${question.question}</td>
				<td>${question.opa}</td>
				<td>${question.opb}</td>
				<td>${question.opc}</td>
				<td>${question.opd}</td>
				<td>${question.answer}</td>
				<td><button><a href="http://localhost:8080/addquestion${question.id}">add Question</a></button></td>			
			</tr>
		</c:forEach>
		
		</table>
	</div>
</body>
</html>