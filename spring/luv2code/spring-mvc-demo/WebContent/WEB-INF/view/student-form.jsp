<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student Registration Form</title>
	</head>
	<body>
		<form:form action="processForm" modelAttribute="student">
			First name: <form:input path="firstName"/><br>
			Last name: <form:input path="lastName"/><br>
			Country:
			 <form:select path="country">
			 	<!-- in input [value: code value, label: display value] -->
			 	<!-- Method 1: manual put the options -->
				<!-- 
				<form:option value="algeria" label="Algeria" />
				<form:option value="palestine" label="Palestine" />
				<form:option value="tunisia" label="Tunisia" />
				<form:option value="maroc" label="Marocco" />
				-->
				
				<!-- Method 2: get the options from java code -->
				<form:options items="${student.countryOptions}" />
			</form:select><br>
			<input type="submit" />
		</form:form>
	</body>
</html>