<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add To do List</title>
<link rel="stylesheet" href="StyleSheet.css">
</head>
<body>
	<h1>Adding List</h1>
	<h2>
		<a href="InsertForm.jsp">Add List</a> &nbsp;&nbsp;&nbsp; <a
			href="http://localhost:8080/CEN-4025C-Module-7/">Index </a>

	</h2>
	<c:if test="${databasePassing == null}">
	</c:if>
	<form action="addData" method="post">
		<table>
			<caption>
				<h2>
					<c:if test="${databasePassing == null}">
               Add List
              </c:if>
				</h2>
			</caption>
			<c:if test="${databasePassing != null}">
				<input type="hidden" name="id"
					value="<c:out value='${databasePassing.id}' />" />
			</c:if>
			<tr>
				<th>List:</th>
				<td><input type="text" name="list" size="100"
					value="<c:out value='${databasePassing.name}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="insert" /></td>
			</tr>
		</table>
	</form>
</body>
</html>