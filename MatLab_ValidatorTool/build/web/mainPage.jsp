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
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>Validations page</h1>
        <p>How to do tests:</p>
        <p>Step 0: You can see the available activities</p>
        <table border="1">
            <tr>
                <td align="center"><b>Activities</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form name="myForm" action="activitiesList.jsp" method="GET">
                        <input type="submit" value="See activities" />
                    </form>
                </td>
            </tr>
        </table>
        <p>Step 1: Enter the name of the activity you want to validate</p>
        <table>
            <tr>
                <td>
                    <form action="SelectActivity" method="post">
                        Enter the name: <input type ="text" name="saname"><br>
                        <input type="submit" name="button1" value="Select Activity" />
                    </form>
                </td>
            </tr>
        </table>
        <p>Step 2: Sumbit your solution</p>
        <table border="1">
            <tr>
                <td align="center"><b>Solution</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form name="myForm" action="uploadPage1.jsp" method="POST">
                        <input type="submit" value="Upload code" />
                    </form>
                </td>
            </tr>
        </table>
        <p>Step 3: Press Validate</p>
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
        <p>Extra 1: Delete all the code uploaded</p>
        <table border="1">
            <tr>
                <td align="center"><b>Delete</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form action="deleteFiles" method="post">
                        <input type="submit" name="button1" value="Delete test files" />
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
