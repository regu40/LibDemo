
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Books</title>
</head>
<body>
	<h1>View Books</h1>
<form action="viewBooks" method="get" commandName="book">
	<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>Book Id</b></td>
			<td><b>Book Name</b></td>
			<td><b>Publisher Name</b></td>
			<td><b>Author Name</b></td>
			<td><b>Publish Year</b></td>
			
		</tr>
		<c:forEach var="books" items="${book}">
			<tr>
				<td>${books.id}</td>
				<td>${books.bookName}</td>
				<td>${books.publisher.publisher_name}</td>
				<td>${books.author.author_name}</td>
				<td>${books.publish_year}</td>
			</tr>
		</c:forEach>
		 <tr><td><input type="submit" value="Back" /> </td></tr>
	</table>
	</form>
	</body>
	</html>