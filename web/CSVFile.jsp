
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Full File</title>
    </head>
    <body>
        <h1>CSV File</h1>
        <table cellspacing='0' border="1" >
            <%
                String fName = System.getProperty("user.dir") + "/solFile/results.csv";
                String thisLine;
                FileInputStream fis = new FileInputStream(fName);
                DataInputStream myInput = new DataInputStream(fis);
                int i = 0;

                while ((thisLine = myInput.readLine()) != null) {
                    String strar[] = thisLine.split(",");
            %><tr><%
                for (int j = 0; j < strar.length; j++) {
                    if (i != 0) {
                        out.print("<td> " + strar[j] + "</td> ");
                    } else {
                        out.print(" <td> <b>" + strar[j] + "</b> </td> ");
                    }
                    i++;
                }
                %></tr><%
                }
                %>
        </table>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>
