<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Hi I am in LogIn</h1>
		<br><br>
		
		<form:form action="login" modelAttribute="student" >
			<label>User Name : </label><form:input path="username"/><br><br>
			<label>User Name : </label><form:password path="password"/><br><br>
			
			<br><br><br><br>
			<form:button>Submit</form:button>
		</form:form>
		
		
	</div>
</body>
</html>