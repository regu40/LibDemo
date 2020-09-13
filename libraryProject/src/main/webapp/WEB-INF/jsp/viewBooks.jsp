

<head>
      <title>Library Application</title>
   </head>

   <body>
      <form action = "/search" method = "post">
         <input type="text" name="search"> <br>
        Search By : <select name = "name">
            <option value = "book" selected>Book Name</option>
            <!-- <option value = "author">Author</option>
            <option value = "publisher">Publisher</option> -->
         </select>
         
         <input type = "submit" value = "Submit" />
      </form>
      
      
      <form action = "/backAction" method = "post">
      <input type = "submit" value = "Back" />
      </form>
   </body>

</html>