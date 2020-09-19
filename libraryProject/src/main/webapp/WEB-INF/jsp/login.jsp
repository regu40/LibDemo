<html>

<head>
<title>Library Application</title>
<script type="text/javascript">

function validate()
{
	if(document.getElementById("name").value == ""){
		alert("Please Enter User Name");
		return false;
	}
	if(document.getElementById("password").value == ""){
		alert("Please Enter Password");
		return false;
	}
	
	}
</script>
</head>

<body>
<h1 align="center" style="color: blue">Library Application</h1>
<br>
<br>
    <font color="red">${errorMessage}</font>
    <form action="login" method="post" onsubmit="return validate()">
    <table border="0" align="center">
    <tr><td> Name :</td><td><input type="text" name="name" id="name"/></td></tr>
    <tr><td>Password :</td><td><input type="password" name="password" id="password"/></td></tr>
    <tr><td></td><td><input type="submit" value="login" align="right"/></td></tr>
    </table>  
        
    </form>
</body>

</html>