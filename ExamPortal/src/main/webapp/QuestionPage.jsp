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
		<h1>Question Page</h1>
		<br><br>
		
		<label>Question : </label>${sendQue.question }<br><br>
		
		<label>1) </label><input type="radio" name="answer" value="1">${sendQue.opa}<br>
		<label>2) </label><input type="radio" name="answer" value="2">${sendQue.opb}<br>
		<label>3) </label><input type="radio" name="answer" value="3">${sendQue.opc}<br>
		<label>4) </label><input type="radio" name="answer" value="4">${sendQue.opd}<br>
		
		
		<br><br><br>
		
		<c:forEach var="count" begin="1" end="${qSize}">
			<button onclick="getlink(${count})">${count}</button>
		</c:forEach>
		
		<br><br><br>
		
		<button onclick="getlink(10000)"><h1>Submit</h1></button>
		
	</div>
	
	<script type="text/javascript">
	function getlink(gque)
	{
		var ans =0;
		 ans = document.querySelector('input[name="answer"]:checked').value;

		if(ans>=0 && ans<=4)
		{
			window.location.href = 'http://localhost:8080/'+ans+'testloop'+gque;
		}
		else
		{
			window.location.href = 'http://localhost:8080/0testloop'+gque;
		}
		
	}
	</script>
	
</body>
</html>