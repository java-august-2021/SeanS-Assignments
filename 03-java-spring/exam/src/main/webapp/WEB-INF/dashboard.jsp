<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Welcome, ${thisUser.name}</h1>
<a href="/logout">Log Out</a>
<h2>TV Shows</h2>
<table>
<tr>

<th>Show</th>

<th>Network</th>

<th>Description</th>

</tr>
<tbody>
<c:forEach items="${allIdeas}" var="idea">
<tr>
<td><a href="/details/${idea.id}">${idea.iText}</a></td>
<td>${idea.nText}</td>
<td>${idea.dText}</td>
</tr>
</c:forEach>

</tbody>

</table>

<p><a href="/new">Add a Show</a><p>

</body>
</html>