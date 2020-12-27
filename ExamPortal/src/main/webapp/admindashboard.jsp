<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.hide
{
	display: none;
}
.show {display:block;}
</style>
</head>
<body>
	<div>
		<h1 align="center">Admin Pannel</h1>
		<br><br>
		
		<table border="1">
			<tr>
				<th>TestID</th>
				<th>Test Name</th>
				<th>Que Mgmt</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="test" items="${tlist}">
				<tr>
					<td>${test.id}</td>
					<td>${test.tName}</td>
					<td><button><a href="http://localhost:8080/questionmgmt${test.id}">QuestionMgmt</a></button></td>
					<td><button><a href="http://localhost:8080/deletetest${test.id}">Delete</a></button></td>
				</tr>
			</c:forEach>
			
		</table>
		<br><br><br>
		
		<button id="myBtn" onclick="open()">AddTest</button>
		
		<div class="hide" id="s"><input type="text" id="name" ><button onclick="url()">Submit</button> </div>
		
	</div>
	
	<script type="text/javascript">
	document.getElementById("myBtn").onclick = function() {open()};
		function open()
		{
		
			document.getElementById("s").classList.toggle("show");
		    
		}

		function url()
		{
			var x = document.getElementById("name").value;
			
			window.location.href = 'http://localhost:8080/'+x;
		}
	</script>
</body>
</html>