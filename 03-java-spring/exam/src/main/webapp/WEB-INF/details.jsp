<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>${thisIdea.iText}</h1>
<p><a href="/ideas">Back to Dashboard</a><p>
<p>Posted By: ${thisIdea.user.name}</p>
<p>Network: ${thisIdea.nText}</p>
<p>Description: ${thisIdea.dText}</p>

<p><a href="/edit/${thisIdea.id}">Edit</a>
<p><a href="/delete/${thisIdea.id}">Delete</a>

</body>
</html>