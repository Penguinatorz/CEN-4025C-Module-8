<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To do List</title>
<link rel="stylesheet" href="StyleSheet.css">
</head>
<body>
	<h1>To do List</h1>
	<form name="View" action=listData>
		<input type="submit" value="View List">
	</form>
	<form name="Add" action="InsertForm.jsp" method="post">
		<input type="submit" value=" Add to do List">
	</form>
	<form name="Delete" action="listView" method="post">
		<input type="submit" value=" Delete to do List">
	</form>
</body>
</html>