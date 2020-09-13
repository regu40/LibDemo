<html>

<head>
<title>Library Application</title>
</head>

<body>
<h1>Library Application</h1>
<font color="red">${errorMessage}</font>
    <form action="submitUser" method="post">
    <table>
    <input type="hidden" name="id" value="${user.id}"/>
    <tr><td> Name :</td><td><input type="text" name="userName" value="${user.userName}" /></td></tr>
    <tr><td>Password :</td><td><input type="text" name="password" value="${user.password}"/></td></tr>
    <tr><td><input type="submit" /></td><td></td>
    </table>  
        
    </form>
     
</body>

</html>