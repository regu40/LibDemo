<html>

<head>
<title>Library Application</title>
</head>

<body>
<h1>Library Application</h1>
<%if(session.getAttribute("userName").equals("admin")) {%>
<table>
<tr><td><a href="/addUser">Add User</a></td></tr>
<tr><td><a href="/viewUser">View Users</a></td></tr>
<tr><td><a href="/addBooks">Add Book Details</a></td></tr>
<tr><td><a href="/viewBooks">View Books</a></td></tr>
</table>
     <%} else{%>
     
     <table>
<tr><td><a href="/viewBooks">View Books</a></td></tr>
</table>
<%} %>

<br>
<br>
<a href="/">Logout</a>
</body>

</html>