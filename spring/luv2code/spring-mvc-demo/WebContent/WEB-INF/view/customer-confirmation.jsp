<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Registration Form</title>
</head>
<body>
	<h2>Confirm Customer</h2>
	<p>The customer is confirmed:</p>
	<ul>
		<li>First name: ${customer.firstName}</li>
		<li>Last name: ${customer.lastName}</li>
		<li>Mark: ${customer.mark}</li>
		<li>Postal code: ${customer.postalCode}</li>
		<li>Course code: ${customer.courseCode}</li>
	</ul>
</body>
</html>