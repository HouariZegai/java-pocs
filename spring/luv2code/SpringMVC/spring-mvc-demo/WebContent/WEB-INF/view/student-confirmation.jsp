<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>
</head>
<body>
<h2>Confirm Student</h2>
<p>Congrate! you successfully add that he has this coordination:</p>
<ul>
    <li>First name: ${student.firstName}</li>
    <li>First name: ${student.lastName}</li>
    <li>Country: ${student.country}</li>
    <li>Favorite language: ${student.favoriteLanguage}</li>
    <li>Operating systems:
        <ul>
            <c:forEach var="temp" items="${student.operatingSystems}">
                <li>${temp}</li>
            </c:forEach>
        </ul>
    </li>
</ul>
</body>
</html>