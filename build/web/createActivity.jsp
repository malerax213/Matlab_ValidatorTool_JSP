<%-- 
    Document   : activitiesList
    Created on : 09-mar-2018, 11:39:58
    Author     : alexa
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities</title>
    </head>
    <body>
        <h1>Create activity</h1>
            <form action="Activity" method="post">
                Enter the name of the activity : <input type ="text" name="aname"><br>
                Enter its course : <input type="password" name="acourse"><br>
                <input type="submit" name="button1" value="Sumbit" />     
            </form>
            <p></p>
            <form name="myForm" action="mainPageAdmin.jsp" method="POST">
                <input type="submit" value="Go back" />
            </form>
    </body>
</html>
