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
            
            if(!session.getAttribute("username").equals("1")){ // IMPORTANT: CHANGE 1 TO ADMIN
                response.sendRedirect("mainPage.jsp");
            }
        %>
        <h1>Matlab Validator Tool</h1>
        <p>Hi, <%= session.getAttribute( "username" ) %>!</p>
        <p>Handle activities:</p>
        <table border="1">
            <tr>
                <td align="center"><b>Activities</b></td>
                <td align="center"><b>Create activity</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form name="myForm" action="activitiesList.jsp" method="GET">
                        <input type="submit" value="See activities" />
                    </form>
                </td>
                <td align="center">
                    <form name="myForm" action="createActivity.jsp" method="GET">
                        <input type="submit" value="Create" />
                    </form>
                </td>
            </tr>
        </table>
        <p></p>
        <p>Do tests:</p>
        <table border="1">
            <tr>
                <td align="center"><b>Activities</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form name="myForm" action="adminTests.jsp" method="GET">
                        <input type="submit" value="Go to tests page" />
                    </form>
                </td>
            </tr>
        </table>
        <p></p>
<form method="link" action="Logout">
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
