<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Task</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Create a New TV Show</h1>
<form:form action="/ideas/new" method="POST" modelAttribute="idea">
<form:input type="hidden" value="${user_id}" path="user"/>

<p>
<form:label path="iText">Title:</form:label>
<form:errors path="iText"/>
<form:input path="iText" type="text"/>
</p>

<p>
<form:label path="nText">Network:</form:label>
<form:errors path="nText"/>
<form:input path="nText" type="text"/>
</p>

<p>
<form:label path="dText">Description:</form:label>
<form:errors path="dText"/>
<form:input path="dText" type="text"/>
</p>
<a href="/ideas">Cancel</a>
<button>Submit</button>
</form:form>

</body>
</html>