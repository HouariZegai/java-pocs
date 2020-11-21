<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Registration form (using validation)</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>
<i>Fill out the form. asterisk (*) means required.</i><br>

<form:form action="processForm" modelAttribute="customer">
    First name: <form:input path="firstName"/><br>
    Last name (*): <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/><br>

    Mark: <form:input path="mark"/>
    <form:errors path="mark" cssClass="error"/><br>

    Postal code: <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/><br>

    Course code: <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/><br>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>