<%-- 
    Document   : LogReader
    Created on : 01-feb-2018, 11:09:03
    Author     : alex
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
            File txtFilePath = new File(System.getProperty("user.dir")+"/solFile/wlog.txt");
            BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
                out.println("<br/>");
            }
        %>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>