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
	<h1 align="center">Review</h1>
	
	<br><br><br>
	
	<table border="1">
		<tr>
			<th>Question</th>
			<th>Option 1 </th>
			<th>Option 2 </th>
			<th>Option 3 </th>
			<th>Option 4 </th>
			<th>Your Answer</th>
			<th>Correct Answer</th>
		</tr>
		
	<c:forEach var="print" items="${revlist}">
		<tr>
			<td>${print.question.question}</td>
			<td>${print.question.opa}</td>
			<td>${print.question.opb}</td>
			<td>${print.question.opc}</td>
			<td>${print.question.opd}</td>
			<td>${print.userChoice}</td>
			<td>${print.question.answer}</td>
		</tr>
	</c:forEach>
	
	</table>
	
</div>
</body>
</html>