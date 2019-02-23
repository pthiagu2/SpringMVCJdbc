<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Engines List</title>
</head>
<body>
	<h2>My Favourite Search Engines</h2>
	<p>Following is the list of the search engines, edit them, remove
		or update.</p>
	<table border="1">
		<tr>

			<th>ID</th>
			<th>NAME</th>
			<th>URL</th>
			<th>Actions</th>

		</tr>
		<c:forEach var="searchEngine" items="${searchEnginesList}">
			<tr>
				<td>${searchEngine.id}</td>
				<td>${searchEngine.name}</td>
				<td>${searchEngine.url}</td>
				<td><a
					href="${pageContext.request.contextPath}/edit/${searchEngine.id}.html">Edit</a>
					<a
					href="${pageContext.request.contextPath}/delete/${searchEngine.id}.html">Delete
				</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}/index">Home</a> | <a
			href="${pageContext.request.contextPath}/newSearchEngine">New</a>
	</p>
</body>
</html>