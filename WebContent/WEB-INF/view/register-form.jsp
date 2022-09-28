<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="resources/css/myStyle.css">
		<title>Registration form</title>
		<h2> Register as a new user </h2>
	</head>
	
	<body>
		<h3>Fill out the form</h3>
		<hr>
		<br>
		
		<form:form action="processForm" modelAttribute="user">
			First name: <form:input path="firstName"/>
			<br><br>
			
			Last name: <form:input path="lastName"/>
			<br><br>
			
			Age: <form:input path="age"/>
			<br><br>
			
			Gender: 
				Male <form:radiobutton path="gender" value="M"/>
				Female <form:radiobutton path="gender" value="F"/>
			<br><br>
			
			Country: <form:select path="country">
					 <form:options items="${countries}"/>
					 </form:select>
			<br><br>
			
			Email: <form:input path="email"/>
			<br><br>
			
			Password: <form:input path="password"/>
			<br><br>
			
			<input type="submit" value="Submit">
			
		</form:form>
	</body>

</html>