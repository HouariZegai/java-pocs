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
				<form:option value="algeria" label="Algeria" /> <!-- value: code value, label: display value -->
				<form:option value="palestine" label="Palestine" />
				<form:option value="tunisia" label="Tunisia" />
				<form:option value="maroc" label="Marocco" />
			</form:select><br>
			<input type="submit" />
		</form:form>
	</body>
</html>