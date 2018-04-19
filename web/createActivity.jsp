<%-- 
    Document   : activitiesList
    Created on : 09-mar-2018, 11:39:58
    Author     : alexa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities</title>
    </head>
    <body>
        <h1>Create activity</h1>
        <form method="post" action="Activity" enctype="multipart/form-data">
            Enter the name of the activity : <input type ="text" name="aname"><br>
            Enter its course : <input type="text" name="acourse"><br>
            <p></p>
            Upload solution : <input type="file" name="file1" size="50"/>
            <p></p>
            Upload script : <input type="file" name="file2" size="50"/>
            <p></p>
            <input type="submit" name="button1" value="Sumbit" />     
        </form>
        <p></p>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>
