
<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summarized File</title>
    </head>
    <body>
        <h1>Summarized File</h1>
        <object data="${pageContext.request.contextPath}/SummarizedTest.pdf" 
                type="application/pdf" width="1000" height="800">
            <a href="${pageContext.request.contextPath}/SummarizedTest.pdf">Download file.pdf</a>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>
