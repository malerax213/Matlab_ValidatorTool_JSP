<%-- 
    Document   : mainPage
    Created on : 01-feb-2018, 9:47:45
    Author     : alex
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
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
            Object user = session.getAttribute("username");
            String userUsed = user.toString();
        %>
        <h1>Validations page</h1>
        <p>How to do tests:</p>
        <p>Handle your assigned activities:</p>
        <table border="1">
            <%
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/navin";
                String username = "root";
                String password = "admin";
                String query = "select course from login WHERE login = '" + userUsed + "';";
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()){
                    System.out.println(rs.getInt("course"));
                
            %>
            <tr>
                <td align="center"><b>Your activities</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form name="myForm" action="activitiesListUser.jsp" method="GET">
                        <input type="hidden" name="course" value=<%=rs.getInt("course")%> />
                        <input type="submit" value="See activities" />
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
        <p></p>
        <form method="link" action="Logout">
            <input type="submit" value="Logout"/>
        </form>
    </body>
</html>
