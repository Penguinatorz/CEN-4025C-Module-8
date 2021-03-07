<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Delete To do List</title>
<link rel="stylesheet" href="StyleSheet.css">
</head>
<body>
	<h1>Delete a List</h1>
	<h2>
		<a href="InsertForm.jsp">Add List</a> &nbsp;&nbsp;&nbsp; <a
			href="http://localhost:8080/CEN-4025C-Module-7/">Index </a>
	</h2>
	<form action="listData">
			<table>
				<tr>
					<th>ID</th>
					<th>List</th>
				</tr>
				<c:forEach items="${listData}" var="databasePassing">
					<tr>
						<td>${databasePassing.id}</td>
						<td>${databasePassing.list}</td>
						<td><a
							href="delete?id=<c:out value='${databasePassing.id}' />">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
	</form>
</body>
</html>