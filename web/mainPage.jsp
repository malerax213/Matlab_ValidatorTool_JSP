<%-- 
    Document   : mainPage
    Created on : 01-feb-2018, 9:47:45
    Author     : alex
--%>

<%@page import="java.io.File"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MatLab Validator Tool</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
            
            if(session.getAttribute("username")==null){
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>Matlab Validator Tool</h1>
        <p>Hi, <%= session.getAttribute( "username" ) %>!</p>
        <p>How to use this validator: </p>
        <p>Step 1: Upload the code pressing the "Upload code" button from the "Code" table </p>
        <p>
        <table border="1">
            <tr>
                <td align="center"><b>Code</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form name="myForm" action="uploadPage1.jsp" method="POST">
                        <input type="submit" value="Upload code" />
                    </form>
                </td>
            </tr>
        </table>
    </p>
    
    <p>Step 2: Upload the solution file pressing the "Upload solution" button from the "Solution" table </p>
    <p>
    <table border="1">
        <tr>
            <td align="center"><b>Solution</b></td>
        </tr>
        <tr>
            <td align="center">
                <form name="myForm" action="uploadPage2.jsp" method="POST">
                    <input type="submit" value="Upload solution" />
                </form>
            </td>
        </tr>
    </table>
</p>

<p>Step 3: Press the "Validate" button from the "Tool" table in order to check if the code passes the tests</p>
<p>
<table border="1">
    <tr>
        <td align="center"><b>Tool</b></td>
    </tr>
    <tr>
        <td align="center">
            <form action="${pageContext.request.contextPath}/myServlet" method="post">
                <input type="submit" name="button1" value="Validate" />
            </form>  
        </td>
    </tr>
</table>
</p>
<form method="link" action="Logout">
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
