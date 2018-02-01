<%-- 
    Document   : LogReader
    Created on : 01-feb-2018, 11:09:03
    Author     : alexa
--%>

<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Text</title>
    </head>
    <body>
        <p>Output:</p>
        <%
            String txtFilePath = "C:\\solFile\\wlog.txt";
            BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                out.println(line);
                out.println("<br/>");
            }
        %>
        <form name="myForm" action="mainPage.jsp" method="POST">
            <input type="submit" value="Go back" />
        </form>
    </body>
</html>
