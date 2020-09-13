<html>

<head>
<title>Library Application</title>
</head>

<body>
<h1>Library Application</h1>
<font color="red">${errorMessage}</font>
    <form action="submitBook" method="post">
    <table>
    <input type="hidden" name="status" value="1"/>
    <tr><td> Book Name :</td><td><input type="text" name="bookName"  /></td></tr>
    <tr><td>Publish Year :</td><td><input type="text" name="publish_year" /></td></tr>
    <tr><td> Author Name :</td><td><input type="text" name="author.author_name"  /></td></tr>
    <tr><td>Publisher Name :</td><td><input type="text" name="publisher.publisher_name" /></td></tr>
    
    <tr><td><input type="submit" /></td><td></td>
    </table>  
        
    </form>
     
</body>

</html>