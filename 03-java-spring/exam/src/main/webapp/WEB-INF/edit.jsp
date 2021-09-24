<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit My Task</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<h1>${thisIdea.iText}</h1>

<form:form action="/edit/${idea.id}" method="POST" modelAttribute="idea">

    <p>
        <form:label path="iText">Title</form:label>
        <form:errors path="iText"/>
        <form:input path="iText"/>
    </p>
    <p>
        <form:label path="nText">Network</form:label>
        <form:errors path="nText"/>
        <form:input path="nText"/>
    </p>
    <p>
        <form:label path="dText">Description</form:label>
        <form:errors path="dText"/>
        <form:input path="dText"/>
    </p>
    <a href="/ideas">Cancel</a>
	<input type="submit" value="Submit"/>

</form:form>

</body>
</html>