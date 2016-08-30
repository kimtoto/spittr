<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Spitter</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Register</h1>

	<sf:form method="POST" commandName="spitter">
		First Name: <sf:input path="firstName"/>
		<sf:errors path="firstName" cssClass="error"/>
		<input type="submit" value="Register" />
	</sf:form>
</body>
</html>
