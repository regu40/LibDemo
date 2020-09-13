<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Users</title>
</head>
<body>
	<h1>View User Details</h1>
 <font color="red">${errorMessage}</font>
	<form action="backAction" method="post" commandName="user">
	<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>User Id</b></td>
			<td><b>Name</b></td>
			<td><b>Password</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>
			
		</tr>
		<c:forEach var="users" items="${user}">
			<tr>
				<td>${users.id}</td>
				<td>${users.userName}</td>
				<td>${users.password}</td>
				<td><a href="/editUser?id=${users.id}">Edit</a></td>
                <td><a href="/deleteUser?id=${users.id}">Delete</a></td>
			</tr>
		</c:forEach>
		 <tr><td><input type="submit" value="Back" /> </td></tr>
	</table>
	</form>
</body>
</html>