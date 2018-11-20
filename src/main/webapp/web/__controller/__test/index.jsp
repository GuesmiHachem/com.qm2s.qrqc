<html>
   <head>
      <title>File Uploading Form</title>
   </head>
   
   <body>
      <h3>File Upload:</h3>
      Select a file to upload: <br />
      <form action = "UploadFile.jsp" method = "post"
         enctype = "multipart/form-data">
         <input type = "text" name = "ss" size = "50" />
         <input type = "file" name = "file1" size = "50" />
         <br />
         <input type = "submit" value = "Upload File" />
      </form>
   </body>
   
</html>