
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Result page</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }

            if (!session.getAttribute("username").equals("1")) { // IMPORTANT: CHANGE 1 TO ADMIN
                response.sendRedirect("mainPage.jsp");
            }
        %>
        <div>
            <h3>${message }</h3>
        </div>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>