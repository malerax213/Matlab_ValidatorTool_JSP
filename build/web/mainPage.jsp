<%-- 
    Document   : mainPage
    Created on : 01-feb-2018, 9:47:45
    Author     : alexa
--%>

<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MatLab Validator Tool</title>
    </head>
    <body>
        <h1>Matlab Validator Tool</h1>
        <p>Upload your code here: </p>
        <form name="myForm" action="index.jsp" method="POST">
            <input type="submit" value="Upload code" />
        </form>
        <form action="${pageContext.request.contextPath}/myServlet" method="post">
            <input type="submit" name="button1" value="Check Output" />
            
        </form>   
    </body>
</html>
