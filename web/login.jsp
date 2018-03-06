<%-- 
    Document   : login.jsp
    Created on : 06-mar-2018, 10:47:54
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="Login" method="post">
            Enter username : <input type ="text" name="uname"><br>
            Enter password : <input type="password" name="pass"><br>
            <input type="submit" name="button1" value="Login" />     
        </form>
    </body>
</html>
