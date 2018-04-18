
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tests page</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>Tests page</h1>
        <p>Test Page:</p>
        <p>Step 1: Sumbit the solution you want to test</p>
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
        <p>Step 2: Press Validate</p>
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
        <p></p>
        <p>Note: All the uploaded files will be deleted after pressing the "Validate" button.</p>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>
