<%-- 
    Document   : uploadPage1
    Created on : 05-feb-2018, 10:52:04
    Author     : alex
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload page</title>
    </head>
    <body>
        <h1>Select Folder</h1>
        <form method="post" action="FolderServlet" >
            Enter the path of the main folder: <input type ="text" name="f_path">
            <p></p>
            <input type="submit" name="button1" value="Sumbit" />     
        </form>
        <p></p>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>